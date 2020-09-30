/*********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 24/09/2020
 -Description           : ILoginUser 
 						  interface for User
 						  management system
**********************************************************/
package com.capgemini.go.user.service;

import java.util.List;

import com.capgemini.go.user.model.UserBean;

public interface ILoginUser {

	public UserBean userLogin(String userId,String password) ;
	
	public List<UserBean> allUsers() ;
	
	public UserBean getUserByUserId(String userId);
	
}
