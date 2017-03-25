package com.boot;

import com.boot.config.DataConfig;
import com.boot.config.MailConfig;
import com.boot.config.PersonConfig;
import com.boot.model.po.Father;
import com.boot.model.po.Person;
import com.boot.model.po.Role;
import com.boot.model.po.Son;
import com.boot.model.vo.Filter;
import com.boot.model.vo.JsonResponse;
import com.boot.model.vo.User;
import com.boot.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import java.util.*;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class}) //排除链接本地mongo
@RestController
public class SpringbootdemoApplication{

	private static Logger logger = Logger.getLogger(SpringbootdemoApplication
			.class);

	@Value("${spring.name}")
	String name;

	@Value("${mail}")
	String mail;//因为application.properties是默认的所以可以直接注入

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
	@Autowired
	MailConfig mailConfig;

	@Autowired
	PersonConfig personConfig;

	@Autowired
	DataConfig dataConfig;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	PersonMongoRepository personMongoRepository;

	@Resource(name = "mongoTemplate")
	MongoTemplate mongoTemplate;

	@Autowired
	MongoTemplate mongoTemplate1;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Resource(name="redisTemplate")
	RedisTemplate<String, User> redisTemplate;

	@Autowired
	SonRepository sonRepository;

	@Autowired
	FatherRepository fatherRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Resource(name="jedisConnectionFactory")
	JedisConnectionFactory jedisConnectionFactory;

	@RequestMapping("/int")
	public int getInt(){
		jedisConnectionFactory.destroy();
		return mailConfig.mailcount;
	}

	@RequestMapping(value = "/left", method = RequestMethod.GET)
	public List testLeftJoinSql(){
		try{
			return fatherRepository.testLeftJoin();
		}catch (Exception e){
			System.out.println(e);
			return null;
		}
	}

	@RequestMapping("/value")
	public Map getValue(){
		Map map = new HashMap<String,Object>();

		map.put("name", name);
		map.put("mailCount", mailConfig.mailcount);
		map.put("mail",mail);
		map.put("person",personConfig.getProperty("person"));
		map.put("data", dataConfig.getDataModel());
		return map;
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Person getPerson(){
		return personRepository.findById("0001");
		//return personRepository.findAll().get(0);
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Person> getPersons(){
		return personRepository.findByName("zhangsan");
		//return personRepository.findById("0001");

		//return personRepository.findAll().get(0);
	}

	@RequestMapping(value="/all", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Person> getAllPerson(){
		return personRepository.findAll();
	}

	@RequestMapping(value="page",method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<Person> getPagePerson(){
		//Pageable pageable = new PageRequest(1,1);
		Filter filter = new Filter(0,1);
		return personRepository.findAll(filter);
	}

	@RequestMapping(value = "customPage",method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<Person> customPage(){

		return personRepository.findAll(new Specification(){
			@Override
			public Predicate toPredicate(Root root,CriteriaQuery
					criteriaQuery,CriteriaBuilder criteriaBuilder){
				//Predicate p = criteriaQuery.getGroupRestriction();
				//criteriaQuery.getRestriction();
				Predicate p = criteriaBuilder.equal(root.get("id").as(String
						.class),
						"0001");
				criteriaQuery.where(p);
				return null;
			}
		},new PageRequest(0,1));
	}
	@RequestMapping(value = "str",method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Person> getStr(){
		return personRepository.showWord();
	}

	@RequestMapping(value="mongo",method = RequestMethod.GET)
	public List<Person> showMongo(){
		 //personRepository.save(new Person("0003","liuer",20));
		//return personRepository.findById("0003");
		personMongoRepository.save(new Person("0002","zhangsan",15));
		return personMongoRepository.findAll();
	}

	@RequestMapping(value="mongoPage", method = RequestMethod.GET)
	public Page<Person> showMongePage(){
		return personMongoRepository.findAll(new PageRequest(1,1));
	}

	@RequestMapping(value="redis",method = RequestMethod.GET)
	public String testRedis(){
		return stringRedisTemplate.opsForValue().get("name");
	}

	@RequestMapping(value="objectsRedis", method = RequestMethod.GET)
	public List<User> objectsRedis(){
		List<User> users = new ArrayList<>();
		users.add(new User("zhangsan",10));
		users.add(new User("lisan",12));
		users.add(new User("wangwu",8));

		redisTemplate.opsForList().leftPushAll("user",users);
		return redisTemplate.opsForList().range("user",0,46);
		//return redisTemplate.opsForList().rightPop("user");
	}

	@RequestMapping(value="objectRedis",method = RequestMethod.GET)
	public Long objectRedis(){
		return redisTemplate.opsForList().size("user");
	}

	@RequestMapping(value="son", method = RequestMethod.GET)
	public Son getSon(@RequestParam String sid){
		return sonRepository.findBySid(sid);
	}

	@RequestMapping(value="saveSon",method = RequestMethod.GET)
	public Son saveSon(){
		Son son = new Son();
		son.setSid("0004");
		son.setName("xiaosun");
		son.setAge(24);
		Father father = new Father();
		father.setFid("0001");
		//son.setFather(father);
		sonRepository.save(son);
		return son;
	}

	@RequestMapping(value="updateSon",method=RequestMethod.GET)
	public Son updateSon(){
		Son son = new Son();
		son.setSid("0004");
		son.setName("xiaos");
		son.setAge(15);
		Father father = new Father();
		father.setFid("0001");
		//son.setFather(father);
		sonRepository.saveAndFlush(son);
		return son;
	}

	@RequestMapping(value="spectionSon", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Son getSonSpection(String sN,String fN){
		List<Son> sons = sonRepository.findAll(new Specification<Son>(){
			@Override
			public Predicate toPredicate(Root root,CriteriaQuery criteriaQuery,CriteriaBuilder criteriaBuilder){

				List<Predicate> predicates = new ArrayList<Predicate>();

				predicates.add(criteriaBuilder.equal(root.get("name").as
						(String.class),sN));
				//外接表
				Join join = root.join(root.getModel().getSingularAttribute
						("father",
						Father.class),JoinType.LEFT);
				predicates.add(criteriaBuilder.equal(join.get("name").as
						(String.class),fN));

				return criteriaBuilder.and(predicates.toArray(new
						Predicate[predicates.size()]));
			}
		});
		return sons.get(0);
	}

	@RequestMapping(value = "sonByFid", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Son> findSonsByFid(String fid){
		return sonRepository.findByFid(fid);
		//return null;
	}

	@RequestMapping(value = "allsons", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Son> findAllSons(){
		return sonRepository.findAll();
	}

	@RequestMapping(value = "allfathers", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Father> findAllFathers(){
		return fatherRepository.findAll();
	}

	@RequestMapping(value = "fatherpage", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<Father> findFathersByPage(){
		Pageable pageable = new PageRequest(0,3);
		/*return fatherRepository.findByQuery(pageable);*/
		return null;
	}

	@RequestMapping(value = "fpage", method = RequestMethod.GET)
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Page<Father> findFatherByPage(){
		Specification specification = new Specification(){
			@Override
			public Predicate toPredicate(Root root,CriteriaQuery criteriaQuery,CriteriaBuilder criteriaBuilder){
				/*ListJoin join = root.join(root.getModel().getList
						("sons",Son.class),
						JoinType.LEFT);*/
				List<Predicate> predicateList = new ArrayList<>();
				criteriaQuery.distinct(true);
				Root join = criteriaQuery.from(Son.class);
				Predicate predicate = criteriaBuilder.equal(root.get("fid"),
						join.get
						("fid"));
				predicateList.add(predicate);
				criteriaQuery.groupBy(root.get("fid"));
				Order order = criteriaBuilder.desc(criteriaBuilder.count(join));
				criteriaQuery.orderBy(order);
				criteriaQuery.where(predicateList.toArray(new
				 Predicate[predicateList.size()]));
				return criteriaQuery.getRestriction();
			}
		};
		Pageable pageable = new PageRequest(0,2);

		return fatherRepository.findAll(specification, pageable);
	}

	@RequestMapping(value="/f/count", method = RequestMethod.GET)
	public int countByFid(String fid){
		return fatherRepository.countByFid(fid);
	}

	@RequestMapping(value="/s/count", method = RequestMethod.GET)
	public int countSonByFid(String fid){
		//return sonRepository.countByFid(fid);
		return 0;
	}

	@RequestMapping(value="/save/user", method = RequestMethod.GET)
	public Map saveUser(){
		com.boot.model.po.User user = new com.boot.model.po.User("7",
				"18239506520", "king1");
		//Role role = new Role("1", "Dev");
		Role role = new Role();
		role.setId("2");
		user.setRole(role);
		Map map = new HashMap();
		try{
			userRepository.save(user);
			map.put("data","SUCCESS");
		}catch (Exception e){
			logger.error(e);
			map.put("data","FAIL");
		}
		return map;
	}

	@RequestMapping(value="/save/role", method = RequestMethod.GET)
	public Map saveRole(){
		Role role = new Role("7","Say");
		Set<com.boot.model.po.User> users = new HashSet<>();
		users.add(new com.boot.model.po.User("9","18239506520","Wang"));
		role.setUsers(users);
		Map map = new HashMap();
		try{
			roleRepository.save(role);
			map.put("data","SUCCESS");
		}catch (Exception e){
			logger.error(e);
			map.put("data","FAIL");
		}
		return map;
	}

	@RequestMapping(value="/users", method = RequestMethod.GET)
	public List<com.boot.model.po.User> findUser(){
		return userRepository.findAll();
	}

	@RequestMapping(value="/roles", method = RequestMethod.GET)
	public List<Role> findRole(){
		return roleRepository.findAll();
	}

	@RequestMapping(value="Map", method = RequestMethod.POST, produces =
			"application/json;charset=UTF-8")
	public Map returnMap(@RequestBody Map params){
		System.out.println(params.get("data"));
		System.out.println(params.toString());
		return params;
	}

	@RequestMapping(value="list/map", method = RequestMethod.GET, produces =
			"application/json;charset=UTF-8")
	public JsonResponse<List<Map>> returnListMap(){
		ObjectMapper objectMapper = new ObjectMapper();
		List<Map> mapList = new ArrayList<Map>();
		Map map6 = new HashMap();
		map6.put("name", 6);
		map6.put("data", "hello");
		Map map5 = new HashMap();
		map5.put("name", 5);
		map5.put("data", map6);
		Map map4 = new HashMap();
		map4.put("name", 4);
		map4.put("data", map5);
		Map map3 = new HashMap();
		map3.put("name", 3);
		map3.put("data", map4);
		Map map2 = new HashMap();
		map2.put("name","2");
		map2.put("data",map3);
		Map map1 = new HashMap();
		map1.put("name", "1");
		map1.put("data", map2);
		Map map = new HashMap();
		map.put("name","0");
		map.put("data", map1);

		mapList.add(map);
		Map map7 = new HashMap();
		map7.put("test", "test");
		mapList.add(map7);
		String jsonstr = "";
		Map[] maps =  null;
		try{
			jsonstr = objectMapper.writeValueAsString(mapList);
			maps = objectMapper.readValue(jsonstr, Map[].class);
		}catch (Exception e){
			e.printStackTrace();
		}
		return new JsonResponse<>(mapList);
	}

/*//错误
@RequestMapping(value="s/countSon", method = RequestMethod.GET)
	public int countSonByFidWithSpecial(String fid){
		Specification specification = new Specification(){
			@Override
			public Predicate toPredicate(Root root,CriteriaQuery query,
										 CriteriaBuilder cb){
				return cb.equal(root.get("sid"),"0001");
			}
		};

		int i = sonRepository.countByFid(fid, specification);
		System.out.println(i);
		return i;
	}
*/

/*//错误命名
	@RequestMapping(value="/person/count", method = RequestMethod.GET)
	public int countByPerson(){
		return personRepository.countByAgeIs20();
	}
*/
}
