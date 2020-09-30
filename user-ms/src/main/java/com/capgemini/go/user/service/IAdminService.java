/*********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 24/09/2020
 -Description           : IAdminService 
 						  interface for User management system 
 						  to integrate with Delivery Time Report 
 						  management system
**********************************************************/
package com.capgemini.go.user.service;

import com.capgemini.go.user.model.CategoryLevelEntriesList;
import com.capgemini.go.user.model.ItemLevelEntriesList;
import com.capgemini.go.user.model.RetailerInventoryList;

public interface IAdminService {
	
	ItemLevelEntriesList viewItemLevelDeliveryTimeReport();
	
	CategoryLevelEntriesList viewCategoryLevelDeliveryTimeReport();
	
	CategoryLevelEntriesList viewOutlierCategoryLevelDeliveryTimeReport();
	
	RetailerInventoryList viewItemLevelDeliveryTimeReportByProductId(String productId);
	
	RetailerInventoryList viewCategoryLevelDeliveryTimeReportByCategoryId(int categoryId);

}
