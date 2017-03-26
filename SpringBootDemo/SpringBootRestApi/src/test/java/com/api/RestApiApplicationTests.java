package com.api;

import com.api.model.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestApiApplicationTests {

	@Test
	public void contextLoads() {

		User user = new User();
		user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		user.setName("zhangsan");

		try{

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(user);
			ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bis);
			Object o = (User) ois.readObject();
			System.out.println("over");
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
