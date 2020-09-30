package com.capgemini.go.deliverytimereports;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.go.deliverytimereports.exceptions.NotFoundException;
import com.capgemini.go.deliverytimereports.repository.IProductJpaRepo;
import com.capgemini.go.deliverytimereports.repository.IRetailerInventoryJpaRepo;
import com.capgemini.go.deliverytimereports.service.IDeliveryTimeReportsService;

@SpringBootTest
class DeliveryTimeReportMsApplicationTests {

	@Autowired
	IRetailerInventoryJpaRepo rIrepo;
	
	@Autowired
	IProductJpaRepo pRepo;
	
	@Autowired
	IDeliveryTimeReportsService service;
	
	/*******************************************************************
	 -Test Name          	: testGetCategoryNameByCategoryNumber1()
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: Test for getting category name by category
	  						  id by giving correct category id
	*********************************************************************/
	@Test
	public void testGetCategoryNameByCategoryNumber1() {
		assertEquals("Camping Equipment",service.getCategoryNameByCategoryNumber(1));
	}
	
	/*******************************************************************
	 -Test Name          	: testGetCategoryNameByCategoryNumber2()
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: Test for getting category name by category
	  						  id by giving incorrect category id
	*********************************************************************/
	@Test
	public void testGetCategoryNameByCategoryNumber2() {
		assertFalse("Camping Equipment".equals(service.getCategoryNameByCategoryNumber(5)));
	}
	
	/*******************************************************************
	 -Test Name          	: testNotFoundExceptionForProductId()
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: Test to check if exception is arising when 
	 						  wrong product id in 
	 						  getItemLevelDeliveryTimePeriod()
	*********************************************************************/
	@Test
	public void testNotFoundExceptionForProductId() {
		 Exception exception = assertThrows(NotFoundException.class, () -> {
			 service.getItemLevelDeliveryTimePeriod("789");
		    });
		 
		    String expectedMessage = "Retailer Inventory doesn't contain any data with productId = 789";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	/*******************************************************************
	 -Test Name          	: testNotFoundExceptionForCategoryId()
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: Test to check if exception is arising when 
	 						  wrong category number in 
	 						  getCategoryLevelDeliveryTimePeriod()
	*********************************************************************/
	@Test
	public void testNotFoundExceptionForCategoryId() {
		Exception exception = assertThrows(NotFoundException.class, () -> {
			 service.getCategoryLevelDeliveryTimePeriod(9);
		    });
		 
		    String expectedMessage = "Retailer Inventory doesn't contain any data with categoryId = 9";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	/*******************************************************************
	 -Test Name          	: testNotFoundExceptionForProductUniqueId()
	 -Author				: Keerthi Sree
	 -Creation Date			: 23/09/2020
	 -Description  			: Test to check if exception is arising when 
	 						  wrong product unique id in 
	 						  getDeliveryTimePeriod()
	*********************************************************************/
	@Test
	public void testNotFoundExceptionForProductUniqueId() {
		Exception exception = assertThrows(NotFoundException.class, () -> {
			 service.getDeliveryTimePeriod("hzzzzz");
		    });
		 
		    String expectedMessage = "Retailer Inventory doesn't contain any data with productUniqueId = hzzzzz";
		    String actualMessage = exception.getMessage();
		 
		    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	
	
}
