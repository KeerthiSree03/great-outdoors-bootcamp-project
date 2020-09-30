/*******************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 21/09/2020
 -Description           : Controller for getting Delivery
 						  Time Reports
********************************************************/

package com.capgemini.go.deliverytimereports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.capgemini.go.deliverytimereports.model.CategoryLevelEntriesList;
import com.capgemini.go.deliverytimereports.model.ItemLevelEntriesList;
import com.capgemini.go.deliverytimereports.model.RetailerInventoryList;
import com.capgemini.go.deliverytimereports.service.IDeliveryTimeReportsService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/delivery-time-report")
public class DeliveryTimeReportsController {

	@Autowired
	IDeliveryTimeReportsService service;

	/*******************************************************************
	 -FunctionName          : viewItemLevelDeliveryTimeReport()
	 -Return Type           : ResponseEntity<ItemLevelEntriesList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 22/09/2020
	 -Description  			: To get item wise delivery time report
	*********************************************************************/
	@GetMapping("/item-wise")
	public ResponseEntity<ItemLevelEntriesList> viewItemLevelDeliveryTimeReport() {
		try {
			ItemLevelEntriesList ildtReport = new ItemLevelEntriesList(service.getItemLevelDeliveryTimeReport());
			return new ResponseEntity<ItemLevelEntriesList>(ildtReport, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error generating report", e);
		}
	}

	/*******************************************************************
	 -FunctionName          : viewCategoryLevelDeliveryTimeReport()
	 -Return Type           : ResponseEntity<CategoryLevelEntriesList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 22/09/2020
	 -Description  			: To get category wise delivery time report
	*********************************************************************/
	@GetMapping("/category-wise")
	public ResponseEntity<CategoryLevelEntriesList> viewCategoryLevelDeliveryTimeReport() {
		try {
			CategoryLevelEntriesList cldtReport = new CategoryLevelEntriesList(
					service.getCategoryLevelDeliveryTimeReport());
			return new ResponseEntity<CategoryLevelEntriesList>(cldtReport, HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error generating report", e);
		}
	}

	/*******************************************************************
	 -FunctionName          : viewOutlierCategoryLevelDeliveryTimeReport()
	 -Return Type           : ResponseEntity<CategoryLevelEntriesList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 22/09/2020
	 -Description  			: To get outlier product category wise wise
	  						  delivery time report
	*********************************************************************/
	@GetMapping("/outlier-category-wise")
	public ResponseEntity<CategoryLevelEntriesList> viewOutlierCategoryLevelDeliveryTimeReport() {
		try {
			CategoryLevelEntriesList opcdtReport = new CategoryLevelEntriesList(
					service.getOutlierLevelDeliveryTimeReport());
			return new ResponseEntity<CategoryLevelEntriesList>(opcdtReport, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error generating report", e);
		}
	}

	/***********************************************************************
	 -FunctionName          : viewItemLevelDeliveryTimeReportByProductId()
	 -Input Parameters      : String productId
	 -Return Type           : ResponseEntity<RetailerInventoryList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 22/09/2020
	 -Description  			: To get item wise delivery time report by
	  						  giving product Id
	*************************************************************************/
	@GetMapping("/item-wise/{productId}")
	public ResponseEntity<RetailerInventoryList> viewItemLevelDeliveryTimeReportByProductId(
			@PathVariable String productId) {
		try {
			RetailerInventoryList itemLevelList = new RetailerInventoryList(
					service.getItemWiseReportByProductId(productId));
			return new ResponseEntity<RetailerInventoryList>(itemLevelList, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Id not exists", e);
		}
	}

	/***********************************************************************
	 -FunctionName          : viewCategoryLevelDeliveryTimeReportByCategoryId()
	 -Input Parameters      : int categoryId
	 -Return Type           : ResponseEntity<RetailerInventoryList>
	 -Exception	name		: ResponseStatusException
	 -Author				: Keerthi Sree
	 -Creation Date			: 22/09/2020
	 -Description  			: To get category wise delivery time report by
	  						  giving category number
	*************************************************************************/
	@GetMapping("/category-wise/{categoryId}")
	public ResponseEntity<RetailerInventoryList> viewCategoryLevelDeliveryTimeReportByCategoryId(
			@PathVariable int categoryId) {
		try {
			RetailerInventoryList categoryLevelList = new RetailerInventoryList(
					service.getCategoryWiseReportByCategoryId(categoryId));
			return new ResponseEntity<RetailerInventoryList>(categoryLevelList, HttpStatus.OK);

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Number not exists", e);
		}
	}

}
