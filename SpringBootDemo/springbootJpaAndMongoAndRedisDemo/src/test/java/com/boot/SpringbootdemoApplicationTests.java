package com.boot;

import com.boot.model.po.Role;
import com.boot.model.po.User;
import com.boot.repository.RoleRepository;
import com.boot.repository.UserRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	//@Test
	public void saveUser(){
		User user = new User("1", "18239506520", "rich1");
		Role role = new Role("1", "Manager");
		user.setRole(role);

		userRepository.save(user);
	}

	//@Test
	public void saveRole(){
		Role role = new Role("1","Manager");
		User user = new User("1","15538311995","王");
		User user1 = new User("2","1352652312","sun");
		Set<User> userList = new HashSet<>();
		userList.add(user);
		userList.add(user1);
		role.setUsers(userList);
		roleRepository.save(role);
	}
}
