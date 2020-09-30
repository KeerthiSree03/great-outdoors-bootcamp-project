package com.capgemini.go.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.capgemini.go.user.exceptions.InvalidInputException;
import com.capgemini.go.user.service.ILoginUser;
import com.capgemini.go.user.service.IRegisterUser;

@SpringBootTest
class UserMsApplicationTests {
	
	@Autowired
	IRegisterUser service;
	
	@Autowired
	ILoginUser loginService;
	
	@BeforeEach
	void addUsers() {
		loginService.allUsers();
	}

	@Test
	void testValidatePhoneNo() {
		assertEquals(true, service.validatePhoneNo(1234685783L));
	}
	
	@Test
	void testValidatePassword() {
		assertEquals(true, service.validatePassword("CapgKeerthi@34"));
	}
	
	@Test
	void testValidateEmail() {
		assertEquals(true,service.validateEmail("keerthi@gmail.com"));
	}
	
	@Test
	void testValidateUserId() {
		assertEquals(true,service.validateUserId("Keerthi123"));
	}
	
	@Test
	void testValidatePhoneNoFalse() {
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			service.validatePhoneNo(1234783L);
		    });
		
		    String expectedMessage = "Phone number should be of 10 digits";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	@Test
	void testValidatePasswordFalse() {
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			service.validatePassword("CapgKeerthi,34");
		    });
		 
		    String expectedMessage = "Password should contain:- [uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,should contain atleast 8 characters]";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testValidateEmailFalse() {
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			service.validateEmail("ke@erthi@gmail.com");
		    });
		
		    String expectedMessage = "Email Id NOT valid";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	void testValidateUserIdFalse() {
		
		Exception exception = assertThrows(InvalidInputException.class, () -> {
			service.validateUserId("Keer%i123");
		    });
		
		    String expectedMessage = "UserId should be alphanumeric and start with letter";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	

}
