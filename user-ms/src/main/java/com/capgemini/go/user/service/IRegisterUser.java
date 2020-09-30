/*********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 24/09/2020
 -Description           : IRegisterUser 
 						  interface for User
 						  management system
**********************************************************/
package com.capgemini.go.user.service;

import com.capgemini.go.user.model.UserBean;

public interface IRegisterUser {
	
	UserBean registerUser(UserBean userBean);

	boolean validatePassword(String password);

	boolean validatePhoneNo(long phoneNo);

	boolean validateEmail(String email);

	boolean validateUserId(String userId);

}
