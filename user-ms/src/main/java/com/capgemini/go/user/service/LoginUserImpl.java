/********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 23/09/2020
 -Description           : LoginUserImpl 
 						  implements services for 
 						  ILoginUser for 
 						  User management 
 						  system
*********************************************************/
package com.capgemini.go.user.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.user.exceptions.InvalidInputException;
import com.capgemini.go.user.model.UserBean;
import com.capgemini.go.user.repository.IUserRepo;

@Service
public class LoginUserImpl implements ILoginUser {

	@Autowired
	IUserRepo repo;

	/***************************************************
	 -FunctionName          : addSomeUsers()
	 -Return Type           : void
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description			: To add some users into 
	 						  database before execution 
	 						  starts
	*****************************************************/
	@PostConstruct
	public void addSomeUsers() {
		
		UserBean u1 = new UserBean("Admin", "Keerthi123", "CapgKeerthi@34", "CapgKeerthi@34", 1234567898L,
				"keerthi@gmail.com");
		UserBean u2 = new UserBean("Admin", "Harsha123", "CapgHarsha@34", "CapgHarsha@34", 1234567897L,
				"harsha@gmail.com");
		UserBean u3 = new UserBean("Product Master", "Kavya123", "CapgKavya@34", "CapgKavya@34", 1234567896L,
				"kavya@gmail.com");
		UserBean u4 = new UserBean("Product Master", "Purvi123", "CapgPurvi@34", "CapgPurvi@34", 1234567895L,
				"purvi@gmail.com");
		UserBean u5 = new UserBean("Retailer", "Preha123", "CapgPreha@34", "CapgPreha@34", 1234567894L,
				"preha@gmail.com");
		UserBean u6 = new UserBean("Retailer", "Ram12123", "CapgRam@34", "CapgRam@34", 1234567893L, "ram@gmail.com");
		UserBean u7 = new UserBean("Sales Representative", "Kranthi123", "CapgKranthi@34", "CapgKranthi@34",
				1234567892L, "kranthi@gmail.com");
		UserBean u8 = new UserBean("Sales Representative", "Preethi123", "CapgPreethi@34", "CapgPreethi@34",
				1234567891L, "preethi@gmail.com");

		repo.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8));

	}

	/*******************************************************************
	 -FunctionName          : allUsers()
	 -Return Type           : List<UserBean>
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To get list of all users
	*********************************************************************/
	@Override
	public List<UserBean> allUsers() {
		return repo.findAll();
	}
	
	/*******************************************************************
	 -FunctionName          : userLogin()
	 -Input Parameters      : String userId, String password
	 -Return Type           : UserBean
	 -Exception name		: InvalidInputException
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To login user
	*********************************************************************/

	@Override
	public UserBean userLogin(String userId, String password) {

		if (repo.existsById(userId)) {
			UserBean userBean = repo.getOne(userId);
			if (userBean.getPassword().equals(password)) {
				return userBean;
			} else
				throw new InvalidInputException("Password Incorrect");

		} else
			throw new InvalidInputException("Enter valid userId");

	}

	/*******************************************************************
	 -FunctionName          : allUsers()
	 -Input parameters		: String userId
	 -Return Type           : UserBean
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To get user by user id
	*********************************************************************/
	
	@Override
	public UserBean getUserByUserId(String userId) {
		
		return repo.getOne(userId);
	}

}
