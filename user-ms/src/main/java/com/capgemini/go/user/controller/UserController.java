/***************************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 25/09/2020
 -Description           : Controller for getting functionalities
 						  of user
****************************************************************/
package com.capgemini.go.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.go.user.model.CategoryLevelEntriesList;
import com.capgemini.go.user.model.ItemLevelEntriesList;
import com.capgemini.go.user.model.RetailerInventoryList;
import com.capgemini.go.user.model.UserBean;
import com.capgemini.go.user.model.UserLoginCredentials;
import com.capgemini.go.user.service.IAdminService;
import com.capgemini.go.user.service.ILoginUser;
import com.capgemini.go.user.service.IRegisterUser;
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	IRegisterUser registerService;

	@Autowired
	ILoginUser loginService;
	
	@Autowired
	IAdminService adminService;

	/*******************************************************************
	 -FunctionName          : login()
	 -Input Parameters		: UserLoginCredentials credentials 
	 -Return Type           : ResponseEntity<UserBean>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To login user
	*********************************************************************/
	@PostMapping("/login")
	public ResponseEntity<UserBean> login(@RequestBody UserLoginCredentials credentials) {
		try {
			return new ResponseEntity<UserBean>(
					loginService.userLogin(credentials.getUserId(), credentials.getPassword()), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	/*******************************************************************
	 -FunctionName          : register()
	 -Input Parameters		: UserBean userBean 
	 -Return Type           : ResponseEntity<UserBean>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To register user
	*********************************************************************/
	@PostMapping("/register")
	public ResponseEntity<UserBean> register(@RequestBody UserBean userBean) {
		try {
			return new ResponseEntity<UserBean>(registerService.registerUser(userBean), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	/*******************************************************************
	 -FunctionName          : getUserByUserId()
	 -Input Parameters		: String userId 
	 -Return Type           : ResponseEntity<UserBean>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To get user by user Id
	*********************************************************************/
	@GetMapping("/user-by-id/{userId}")
	public ResponseEntity<UserBean> getUserByUserId(@PathVariable String userId) {
		try {
			return new ResponseEntity<UserBean>(loginService.getUserByUserId(userId), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	/*******************************************************************
	 -FunctionName          : viewItemLevelDeliveryTimeReport()
	 -Return Type           : ResponseEntity<ItemLevelEntriesList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To get item wise delivery time report
	*********************************************************************/
	@GetMapping("/delivery-time-report/item-wise")
	public ResponseEntity<ItemLevelEntriesList> viewItemLevelDeliveryTimeReport(){
		try {
			return new ResponseEntity<ItemLevelEntriesList>(adminService.viewItemLevelDeliveryTimeReport(), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	/*******************************************************************
	 -FunctionName          : viewCategoryLevelDeliveryTimeReport()
	 -Return Type           : ResponseEntity<CategoryLevelEntriesList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To get category wise delivery time report
	*********************************************************************/
	@GetMapping("/delivery-time-report/category-wise")
	public ResponseEntity<CategoryLevelEntriesList> viewCategoryLevelDeliveryTimeReport(){
		try {
			return new ResponseEntity<CategoryLevelEntriesList>(adminService.viewCategoryLevelDeliveryTimeReport(), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	/*******************************************************************
	 -FunctionName          : viewOutlierCategoryLevelDeliveryTimeReport()
	 -Return Type           : ResponseEntity<CategoryLevelEntriesList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To get outlier product category wise wise
	  						  delivery time report
	*********************************************************************/
	@GetMapping("/delivery-time-report/outlier-category-wise")
	public ResponseEntity<CategoryLevelEntriesList> viewOutlierCategoryLevelDeliveryTimeReport(){
		try {
			return new ResponseEntity<CategoryLevelEntriesList>(adminService.viewOutlierCategoryLevelDeliveryTimeReport(), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	
	/***********************************************************************
	 -FunctionName          : viewCategoryLevelDeliveryTimeReportByCategoryId()
	 -Input Parameters      : int categoryId
	 -Return Type           : ResponseEntity<RetailerInventoryList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To get category wise delivery time report by
	  						  giving category number
	*************************************************************************/
	@GetMapping("/delivery-time-report/category-wise/{categoryId}")
	public ResponseEntity<RetailerInventoryList> viewCategoryLevelDeliveryTimeReportByCategoryId(@PathVariable int categoryId){
		try {
			return new ResponseEntity<RetailerInventoryList>(adminService.viewCategoryLevelDeliveryTimeReportByCategoryId(categoryId), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	/***********************************************************************
	 -FunctionName          : viewItemLevelDeliveryTimeReportByProductId()
	 -Input Parameters      : String productId
	 -Return Type           : ResponseEntity<RetailerInventoryList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 25/09/2020
	 -Description  			: To get item wise delivery time report by
	  						  giving product Id
	*************************************************************************/
	@GetMapping("/delivery-time-report/item-wise/{productId}")
	public ResponseEntity<RetailerInventoryList> viewItemLevelDeliveryTimeReportByProductId(@PathVariable String productId){
		try {
			return new ResponseEntity<RetailerInventoryList>(adminService.viewItemLevelDeliveryTimeReportByProductId(productId), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	
	

}
