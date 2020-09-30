/*********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 20/09/2020
 -Description           : IDeliveryTimeReportsService 
 						  interface for Delivery time report
 						  management system
**********************************************************/

package com.capgemini.go.deliverytimereports.service;

import java.util.List;
import java.util.Map;

import com.capgemini.go.deliverytimereports.model.CategoryLevelEntry;
import com.capgemini.go.deliverytimereports.model.ItemLevelEntry;
import com.capgemini.go.deliverytimereports.model.RetailerInventory;
import com.capgemini.go.deliverytimereports.model.RetailerInventory2;

public interface IDeliveryTimeReportsService {

	public List<RetailerInventory> listOfAllRetailerInventory();

	public long getDeliveryTimePeriod(String productUniqueId);

	public long getItemLevelDeliveryTimePeriod(String productId);

	public long getCategoryLevelDeliveryTimePeriod(int categoryNumber);

	public Map<String, Long> getItemLevelDeliveryTimeMap();

	public List<ItemLevelEntry> getItemLevelDeliveryTimeReport();

	public Map<Integer, Long> getCategoryLevelDeliveryTimeMap();

	public List<CategoryLevelEntry> getCategoryLevelDeliveryTimeReport();

	public List<CategoryLevelEntry> getOutlierLevelDeliveryTimeReport();
	
	public List<RetailerInventory2> getItemWiseReportByProductId(String productId);

	public 	List<RetailerInventory2> getCategoryWiseReportByCategoryId(int categoryNumber);

	public String getCategoryNameByCategoryNumber(int categoryNumber);

}
