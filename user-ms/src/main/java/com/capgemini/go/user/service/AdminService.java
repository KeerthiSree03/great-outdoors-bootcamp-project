/********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 24/09/2020
 -Description           : AdminService 
 						  implements services for 
 						  IAdminService for integrating
 						  User management 
 						  system with Delivery Time
 						  Report Management system
*********************************************************/
package com.capgemini.go.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.go.user.model.CategoryLevelEntriesList;
import com.capgemini.go.user.model.ItemLevelEntriesList;
import com.capgemini.go.user.model.RetailerInventoryList;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	RestTemplate restTemplate;

	/**********************************************************************
	 -FunctionName          : viewItemLevelDeliveryTimeReport()
	 -Return Type           : ItemLevelEntriesList
	 -Author				: Keerthi Sree
	 -Creation Date			: 24/09/2020
	 -Description			: To get the viewItemLevelDeliveryTimeReport()
	 						: method from devilery-time-report-ms module
	***********************************************************************/
	@Override
	public ItemLevelEntriesList viewItemLevelDeliveryTimeReport() {
		
		return restTemplate.getForObject("http://localhost:8500/delivery-time-report/item-wise", ItemLevelEntriesList.class);
	}

	/**********************************************************************
	 -FunctionName          : viewCategoryLevelDeliveryTimeReport()
	 -Return Type           : CategoryLevelEntriesList
	 -Author				: Keerthi Sree
	 -Creation Date			: 24/09/2020
	 -Description			: To get the viewCategoryLevelDeliveryTimeReport()
	 						: method from devilery-time-report-ms module
	***********************************************************************/
	@Override
	public CategoryLevelEntriesList viewCategoryLevelDeliveryTimeReport() {
		
		return restTemplate.getForObject("http://localhost:8500/delivery-time-report/category-wise", CategoryLevelEntriesList.class);
	
	}

	/********************************************************************************
	 -FunctionName          : viewOutlierCategoryLevelDeliveryTimeReport()
	 -Return Type           : CategoryLevelEntriesList
	 -Author				: Keerthi Sree
	 -Creation Date			: 24/09/2020
	 -Description			: To get the viewOutlierCategoryLevelDeliveryTimeReport()
	 						: method from devilery-time-report-ms module
	***********************************************************************************/
	@Override
	public CategoryLevelEntriesList viewOutlierCategoryLevelDeliveryTimeReport() {
		
		return restTemplate.getForObject("http://localhost:8500/delivery-time-report/outlier-category-wise", CategoryLevelEntriesList.class);
	
	}

	/********************************************************************************
	 -FunctionName          : viewItemLevelDeliveryTimeReportByProductId()
	 -Input Parameters		: String productId
	 -Return Type           : RetailerInventoryList
	 -Author				: Keerthi Sree
	 -Creation Date			: 24/09/2020
	 -Description			: To get the viewItemLevelDeliveryTimeReportByProductId()
	 						: method from devilery-time-report-ms module
	***********************************************************************************/
	@Override
	public RetailerInventoryList viewItemLevelDeliveryTimeReportByProductId(String productId) {
		
		return restTemplate.getForObject("http://localhost:8500/delivery-time-report/item-wise/"+productId ,  RetailerInventoryList.class);
	
	}

	/********************************************************************************
	 -FunctionName          : viewCategoryLevelDeliveryTimeReportByCategoryId()
	 -Input Parameters		: int categoryId
	 -Return Type           : RetailerInventoryList
	 -Author				: Keerthi Sree
	 -Creation Date			: 24/09/2020
	 -Description			: To get the viewCategoryLevelDeliveryTimeReportByCategoryId()
	 						: method from devilery-time-report-ms module
	***********************************************************************************/
	@Override
	public RetailerInventoryList viewCategoryLevelDeliveryTimeReportByCategoryId(int categoryId) {
		
		return restTemplate.getForObject("http://localhost:8500/delivery-time-report/category-wise/"+categoryId, RetailerInventoryList.class);
	}



}
