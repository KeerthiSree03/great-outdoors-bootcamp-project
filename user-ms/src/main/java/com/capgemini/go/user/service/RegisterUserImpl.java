/********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 23/09/2020
 -Description           : RegisterUserImpl 
 						  implements services for 
 						  IRegisterUser for 
 						  User management 
 						  system
*********************************************************/
package com.capgemini.go.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.user.exceptions.InvalidInputException;
import com.capgemini.go.user.exceptions.UserAlreadyExistsException;
import com.capgemini.go.user.model.UserBean;
import com.capgemini.go.user.repository.IUserRepo;

@Service
public class RegisterUserImpl implements IRegisterUser {

	@Autowired
	IUserRepo repo;

	/*******************************************************************
	 -FunctionName          : registerUser()
	 -Input Parameters      : UserBean userBan
	 -Return Type           : UserBean
	 -Exception name		: InvalidInputException, UserAlreadyExistsException
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To register user
	*********************************************************************/
	@Override
	public UserBean registerUser(UserBean userBean) {
		if (!repo.existsById(userBean.getUserId()) && validateUserId(userBean.getUserId())) {

			if (!repo.existsByEmail(userBean.getEmail()) && validateEmail(userBean.getEmail())) {

				if (!repo.existsByPhoneNo(userBean.getPhoneNo()) && validatePhoneNo(userBean.getPhoneNo())) {

					if (validatePassword(userBean.getPassword())) {

						if (userBean.getPassword().equals(userBean.getRe_enterPassword())) {
							return repo.save(userBean);
						} else
							throw new InvalidInputException(
									"Password mismatch!!! Please check and re-enter the password");

					} else
						throw new InvalidInputException("Enter valid Password");

				} else
					throw new UserAlreadyExistsException(
							"User already exists with phone no. = " + userBean.getPhoneNo());
			} else
				throw new UserAlreadyExistsException("User already exists with email = " + userBean.getEmail());
		} else
			throw new UserAlreadyExistsException("User already exists with userId = " + userBean.getUserId());

	}

	/*******************************************************************
	 -FunctionName          : validatePassword()
	 -Input Parameters      : String password
	 -Return Type           : boolean
	 -Exception name		: InvalidInputException
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To validate password
	*********************************************************************/
	@Override
	public boolean validatePassword(String password) {

		String regex = "[(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$])]{8,}";
		if (password.matches(regex)) {
			return true;
		} else
			throw new InvalidInputException(
					"Password should contain:- [uppercase ,lowercase ,numeric ,any of these characters={'@','$','#'} ,should contain atleast 8 characters]");
	}

	/*******************************************************************
	 -FunctionName          : validatePhoneNo()
	 -Input Parameters      : long phoneNo
	 -Return Type           : boolean
	 -Exception name		: InvalidInputException
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To validate phoneNo
	*********************************************************************/
	
	@Override
	public boolean validatePhoneNo(long phoneNo) {

		String s = Long.toString(phoneNo);
		if (!(s.length() == 10 && s.charAt(0) != 0)) {
			throw new InvalidInputException("Phone number should be of 10 digits");
		}
		return true;
	}

	/*******************************************************************
	 -FunctionName          : validateEmail()
	 -Input Parameters      : String email
	 -Return Type           : boolean
	 -Exception name		: InvalidInputException
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To validate email
	*********************************************************************/
	
	@Override
	public boolean validateEmail(String email) {

		String regex = "[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z]{2,4}";
		if (email.matches(regex))
			return true;
		else
			throw new InvalidInputException("Email Id NOT valid");
	}

	/*******************************************************************
	 -FunctionName          : validateUserId()
	 -Input Parameters      : String userId
	 -Return Type           : boolean
	 -Exception name		: InvalidInputException
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: To validate user Id
	*********************************************************************/
	
	@Override
	public boolean validateUserId(String userId) {

		String regex = "[(?=.*[A-Za-z])][(?=.*[A-Za-z])(?=.*[0-9].{2,4})]{8,}";
		if (!userId.matches(regex)) {
			throw new InvalidInputException("UserId should be alphanumeric and start with letter");
		}
		return true;
	}
	
}
