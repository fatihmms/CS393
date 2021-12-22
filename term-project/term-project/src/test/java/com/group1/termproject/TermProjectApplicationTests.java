package com.group1.termproject;

import com.group1.termproject.DTO.UserDTO;
import com.group1.termproject.DTO.UserMapper;
import com.group1.termproject.model.User;
import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class TermProjectApplicationTests {

	/*@Test
	void contextLoads() {
	}*/
	@Test
	public void shouldMapCarToDto() {
		//given
		User user = new User("ahmet", "mehmet", "asd");

		//when
		UserDTO userDTO = UserMapper.INSTANCE.userToUserDTO( user );

		//then
		String a = userDTO.getName();
		System.out.println(a);

	}


}
