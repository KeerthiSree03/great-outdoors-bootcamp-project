/********************************************************
 -Author                : Keerthi Sree
 -Created/Modified Date : 20/09/2020
 -Description           : DeliveryTimeReportsServiceImpl 
 						  implements services for 
 						  IDeliveryTimeReportsService for 
 						  Delivery time reports management 
 						  system
*********************************************************/

package com.capgemini.go.deliverytimereports.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.go.deliverytimereports.exceptions.NotFoundException;
import com.capgemini.go.deliverytimereports.model.CategoryLevelEntry;
import com.capgemini.go.deliverytimereports.model.ItemLevelEntry;
import com.capgemini.go.deliverytimereports.model.Product;
import com.capgemini.go.deliverytimereports.model.RetailerInventory;
import com.capgemini.go.deliverytimereports.model.RetailerInventory2;
import com.capgemini.go.deliverytimereports.repository.IProductJpaRepo;
import com.capgemini.go.deliverytimereports.repository.IRetailerInventoryJpaRepo;

@Service
public class DeliveryTimeReportsServiceImpl implements IDeliveryTimeReportsService {

	@Autowired
	IRetailerInventoryJpaRepo inventoryRepo;

	@Autowired
	IProductJpaRepo productRepo;

	/***************************************************
	 -FunctionName          : addSomeProducts()
	 -Return Type           : void
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description			: To add some products into 
	 						  database before execution 
	 						  starts
	*****************************************************/
	@PostConstruct
	public void addSomeProducts() {
		Product p1 = new Product("101", "Lanterns", 1, "Camping Equipment");
		Product p2 = new Product("102", "Tents", 1, "Camping Equipment");
		Product p3 = new Product("103", "Camping Pillows", 1, "Camping Equipment");
		Product p4 = new Product("201", "Balls", 2, "Golf Equipment");
		Product p5 = new Product("202", "Golf clubs", 2, "Golf Equipment");
		Product p6 = new Product("203", "Golf bag", 2, "Golf Equipment");
		Product p7 = new Product("301", "Ropes", 3, "Mountaineering Equipment");
		Product p8 = new Product("302", "Climbing packs", 3, "Mountaineering Equipment");
		Product p9 = new Product("303", "Helmets", 3, "Mountaineering Equipment");
		Product p10 = new Product("304", "Pullies", 3, "Mountaineering Equipment");
		Product p11 = new Product("401", "Masks", 4, "Outdoor Protection");
		Product p12 = new Product("402", "Shields", 4, "Outdoor Protection");
		Product p13 = new Product("501", "Shoes", 5, "Personal Accessories");
		Product p14 = new Product("502", "Socks", 5, "Personal Accessories");
		Product p15 = new Product("503", "Hats", 5, "Personal Accessories");
		productRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15));
	}

	/***************************************************
	 -FunctionName          : addSomeRetailerInventory()
	 -Return Type           : void
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description			: To add some retailer inventory
	  						  entries into database before  
	 						  execution starts
	*****************************************************/
	@PostConstruct
	public void addSomeRetailerInventory() {
		RetailerInventory r1 = new RetailerInventory("4a2b", 4, "402", "1gfdsdgh", LocalDate.of(2020, 9, 3),
				LocalDate.of(2020, 9, 6), LocalDate.of(2020, 10, 15));
		RetailerInventory r2 = new RetailerInventory("1a2b", 1, "102", "ghdv", LocalDate.of(2020, 5, 30),
				LocalDate.of(2020, 6, 1), LocalDate.of(2020, 7, 30));
		RetailerInventory r3 = new RetailerInventory("5a2b", 5, "501", "1gfdsdhdggh", LocalDate.of(2020, 6, 25),
				LocalDate.of(2020, 6, 30), LocalDate.of(2020, 8, 6));
		RetailerInventory r4 = new RetailerInventory("3a2b", 3, "301", "hgsffdsdgh", LocalDate.of(2020, 3, 11),
				LocalDate.of(2020, 3, 16), LocalDate.of(2020, 8, 30));
		RetailerInventory r5 = new RetailerInventory("3a2b", 3, "304", "jhgfjg", LocalDate.of(2020, 8, 30),
				LocalDate.of(2020, 9, 3), LocalDate.of(2020, 9, 19));
		RetailerInventory r6 = new RetailerInventory("5a2b", 5, "502", "sh", LocalDate.of(2020, 1, 12),
				LocalDate.of(2020, 1, 18), LocalDate.of(2020, 5, 13));
		RetailerInventory r7 = new RetailerInventory("2a2b", 2, "202", "jeg", LocalDate.of(2020, 2, 15),
				LocalDate.of(2020, 3, 6), LocalDate.of(2020, 4, 30));
		RetailerInventory r8 = new RetailerInventory("4a2b", 4, "401", "teur", LocalDate.of(2020, 4, 13),
				LocalDate.of(2020, 6, 6), LocalDate.of(2020, 7, 10));
		RetailerInventory r9 = new RetailerInventory("1a2b", 1, "103", "irijkwg", LocalDate.of(2020, 7, 17),
				LocalDate.of(2020, 7, 29), LocalDate.of(2020, 9, 17));
		RetailerInventory r10 = new RetailerInventory("1a2b", 1, "103", "jhgk63jh", LocalDate.of(2020, 3, 2),
				LocalDate.of(2020, 4, 7), LocalDate.of(2020, 5, 1));
		RetailerInventory r11 = new RetailerInventory("1a2b", 1, "103", "jysgfuy3", LocalDate.of(2020, 6, 22),
				LocalDate.of(2020, 6, 27), LocalDate.of(2020, 7, 3));
		RetailerInventory r12 = new RetailerInventory("1a2b", 1, "103", "hgfk9j", LocalDate.of(2020, 2, 28),
				LocalDate.of(2020, 3, 28), LocalDate.of(2020, 5, 15));
		RetailerInventory r13 = new RetailerInventory("1a2b", 1, "103", "hgfgddg1", LocalDate.of(2020, 4, 14),
				LocalDate.of(2020, 4, 26), LocalDate.of(2020, 7, 17));
		inventoryRepo.saveAll(Arrays.asList(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13));

	}
 
	/********************************************************
	 -FunctionName          : listOfAllRetailerInventory()
	 -Return Type           : List<RetailerInventory>
	 -Exception name		: NotFoundException
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get list of Retailer Inventoy
	 						  entries
	*********************************************************/
	@Override
	public List<RetailerInventory> listOfAllRetailerInventory() {

		if(inventoryRepo!=null) {
			return inventoryRepo.findAll();
		}
		else {
			throw new NotFoundException(" Retailer Inventory DataBase is Empty ");
		}
		
	}

	/*******************************************************************
	 -FunctionName          : getDeliveryTimePeriod()
	 -Input Parameters      : String productUniqueId
	 -Return Type           : long
	 -Exception name		: NotFoundException
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To calculate and get delivery time period 
	 						  by providing product unique id
	*********************************************************************/
	@Override
	public long getDeliveryTimePeriod(String productUniqueId) {

		if(inventoryRepo.existsById(productUniqueId)) {	
		
		LocalDate dispatchTime = inventoryRepo.getOne(productUniqueId).getProductDispatchTimestamp();
		LocalDate recieveTime = inventoryRepo.getOne(productUniqueId).getProductRecieveTimestamp();

		long deliveryTimePeriod = ChronoUnit.DAYS.between(dispatchTime, recieveTime);

		return deliveryTimePeriod;
		}
		else {
			throw new NotFoundException("Retailer Inventory doesn't contain any data with productUniqueId = "+productUniqueId);
		}
	}

	/*******************************************************************
	 -FunctionName          : getItemLevelDeliveryTimePeriod()
	 -Input Parameters      : String productId
	 -Return Type           : long
	 -Exception	name		: NotFoundException
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To calculate and get average delivery time 
	 						  period of all the items with same productId
	*********************************************************************/
	@Override
	public long getItemLevelDeliveryTimePeriod(String productId) {

		long totalPeriod = 0;
		long averagePeriod;

		List<RetailerInventory> l = listOfAllRetailerInventory();
		List<RetailerInventory> listOfSimilarProductId = new ArrayList<RetailerInventory>();

		if(inventoryRepo.existsByProductId(productId)) {
		for (RetailerInventory dtr : l) {
			if (dtr.getProductId().equals(productId)) {
				listOfSimilarProductId.add(dtr);
			}
		}

		for (RetailerInventory dtr : listOfSimilarProductId) {
			totalPeriod = totalPeriod + getDeliveryTimePeriod(dtr.getProductUniqueId());
		}

		averagePeriod = (totalPeriod / listOfSimilarProductId.size());

		return averagePeriod;
		}
		else {
			throw new NotFoundException("Retailer Inventory doesn't contain any data with productId = "+productId);
		}

	}
	
	/*******************************************************************
	 -FunctionName          : getCategoryLevelDeliveryTimePeriod()
	 -Input Parameters      : String categoryNumber
	 -Return Type           : long
	 -Exception	name		: NotFoundException
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To calculate and get average delivery time 
	 						  period of all the items with same 
							  categoryNumber
	*********************************************************************/
	@Override
	public long getCategoryLevelDeliveryTimePeriod(int categoryNumber) {
		
		long totalAvgPeriod = 0;
		long avgCategoryPeriod;

		List<RetailerInventory> l = listOfAllRetailerInventory();
		List<RetailerInventory> listOfSimilarCategoryNumber = new ArrayList<RetailerInventory>();

		if(inventoryRepo.existsByCategoryNumber(categoryNumber)) {	
		for (RetailerInventory dtr : l) {
			if (dtr.getProductCategoryNumber() == (categoryNumber)) {
				listOfSimilarCategoryNumber.add(dtr);
			}
		}

		for (RetailerInventory dtr : listOfSimilarCategoryNumber) {
			totalAvgPeriod = totalAvgPeriod + getItemLevelDeliveryTimePeriod(dtr.getProductId());
		}

		avgCategoryPeriod = (totalAvgPeriod / listOfSimilarCategoryNumber.size());
		System.out.println("totalPeriod = " + totalAvgPeriod + " count = " + listOfSimilarCategoryNumber.size()
				+ " averagePeriod = " + avgCategoryPeriod);
		return avgCategoryPeriod;
		}
		else {
			throw new NotFoundException("Retailer Inventory doesn't contain any data with categoryId = "+categoryNumber);
		}
	}

	/*******************************************************************
	 -FunctionName          : getItemLevelDeliveryTimeMap()
	 -Return Type           : Map<String, Long>
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the mapping of productId to delivery
	 						  time period
	*********************************************************************/
	@Override
	public Map<String, Long> getItemLevelDeliveryTimeMap() {

		List<RetailerInventory> l = listOfAllRetailerInventory();
		Map<String, Long> report = new HashMap<>();

		for (int i = 0; i < l.size(); i++) {
			RetailerInventory dtr = l.get(i);
			if (!(report.containsKey(dtr.getProductId()))) {
				report.put(dtr.getProductId(), getItemLevelDeliveryTimePeriod(dtr.getProductId()));
			}
		}

		System.err.println(report);
		return report;
	}

	/*******************************************************************
	 -FunctionName          : getItemLevelDeliveryTimeReport()
	 -Return Type           : List<ItemLevelEntry>
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the Item level delivery time report
	*********************************************************************/
	@Override
	public List<ItemLevelEntry> getItemLevelDeliveryTimeReport() {

		List<ItemLevelEntry> l = new ArrayList<ItemLevelEntry>();
		Map<String, Long> map = getItemLevelDeliveryTimeMap();

		for (String productId : map.keySet()) {
			ItemLevelEntry entry = new ItemLevelEntry();
			entry.setProductId(productId);
			entry.setDeliveryTimePeriod(map.get(productId));
			entry.setCategoryNumber(productRepo.getOne(productId).getCategoryId());
			entry.setProductName(productRepo.getOne(productId).getProductName());
			l.add(entry);
		}
		Collections.sort(l, new Comparator<ItemLevelEntry>() {
			@Override
			public int compare(ItemLevelEntry u1, ItemLevelEntry u2) {

				return Long.compare(u1.getDeliveryTimePeriod(), u2.getDeliveryTimePeriod());

			}
		});

		return l;
	}

	/*******************************************************************
	 -FunctionName          : getCategoryLevelDeliveryTimeMap()
	 -Return Type           : Map<Integer, Long>
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the mapping of category number
	  						  to delivery time period
	*********************************************************************/
	@Override
	public Map<Integer, Long> getCategoryLevelDeliveryTimeMap() {

		List<ItemLevelEntry> l = getItemLevelDeliveryTimeReport();
		Map<Integer, Long> report = new HashMap<>();

		for (int i = 0; i < l.size(); i++) {
			ItemLevelEntry dtr = l.get(i);
			if (!(report.containsKey(dtr.getCategoryNumber()))) {
				report.put(dtr.getCategoryNumber(), getCategoryLevelDeliveryTimePeriod(dtr.getCategoryNumber()));
			}
		}

		return report;

	}

	/*******************************************************************
	 -FunctionName          : getCategoryLevelDeliveryTimeReport()
	 -Return Type           : List<ItemLevelEntry>
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the product category level delivery
	 						  time report
	*********************************************************************/
	@Override
	public List<CategoryLevelEntry> getCategoryLevelDeliveryTimeReport() {
		
		List<CategoryLevelEntry> l = new ArrayList<CategoryLevelEntry>();
		Map<Integer, Long> map = getCategoryLevelDeliveryTimeMap();
		
		for (int categoryNum : map.keySet()) {
			CategoryLevelEntry entry = new CategoryLevelEntry();
			entry.setCategoryId(categoryNum);
			entry.setDeliveryTimePeriod(map.get(categoryNum));
			entry.setCategoryName(getCategoryNameByCategoryNumber(categoryNum));
			l.add(entry);
		}
		return l;
	}

	/*******************************************************************
	 -FunctionName          : getCategoryLevelDeliveryTimeReport()
	 -Return Type           : List<ItemLevelEntry>
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the outlier product category level 
	 						  delivery time report
	*********************************************************************/
	@Override
	public List<CategoryLevelEntry> getOutlierLevelDeliveryTimeReport() {
		
		List<CategoryLevelEntry> l = getCategoryLevelDeliveryTimeReport();
		
		Collections.sort(l, new Comparator<CategoryLevelEntry>() {
			@Override
			public int compare(CategoryLevelEntry u1, CategoryLevelEntry u2) {

				return Long.compare(u1.getDeliveryTimePeriod(), u2.getDeliveryTimePeriod());

			}
		});

		return l;
	}

	/*******************************************************************
	 -FunctionName          : getCategoryNameByCategoryNumber()
	 -Input Parameters      : int categoryNumber
	 -Return Type           : String
	 -Exception	name		: NotFoundException
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the category name from category 
	 						  number
	*********************************************************************/
	@Override
	public String getCategoryNameByCategoryNumber(int categoryNumber) {
		
		String cname=null;
		if(productRepo.existsByCategoryId(categoryNumber)) {
		List<Product> list=productRepo.getListByCategoryNumber(categoryNumber);
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).getCategoryName().equalsIgnoreCase(list.get(i+1).getCategoryName())) {
				 cname=list.get(i).getCategoryName();
			}
		}
		
		return cname;
		}
		else throw new NotFoundException("Product with product Category number = "+categoryNumber+" doesn't exist");
	}

	/*******************************************************************
	 -FunctionName          : getItemWiseReportByProductId()
	 -Input Parameters      : String productId
	 -Return Type           : List<RetailerInventory2>
	 -Exception	name		: NotFoundException
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the list of retailer inventory with
	 						  same product id
	*********************************************************************/
	@Override
	public List<RetailerInventory2> getItemWiseReportByProductId(String productId) {

		List<RetailerInventory2> l2 = new ArrayList<RetailerInventory2>();
		if (inventoryRepo.existsByProductId(productId)) {
			for (RetailerInventory ri : inventoryRepo.getItemWiseReportByProductId(productId)) {
				RetailerInventory2 f = new RetailerInventory2();
				f.setRetailerId(ri.getRetailerId());
				f.setProductUniqueId(ri.getProductUniqueId());
				f.setProductId(ri.getProductId());
				f.setProductCategoryNumber(ri.getProductCategoryNumber());
				f.setProductDispatchTimestamp(ri.getProductDispatchTimestamp());
				f.setProductReceiveTimestamp(ri.getProductRecieveTimestamp());
				f.setDeliveryTimePeriod(
						ChronoUnit.DAYS.between(ri.getProductDispatchTimestamp(), ri.getProductRecieveTimestamp()));
				l2.add(f);
			}
			Collections.sort(l2, new Comparator<RetailerInventory2>() {
				@Override
				public int compare(RetailerInventory2 u1, RetailerInventory2 u2) {

					return Long.compare(u1.getDeliveryTimePeriod(), u2.getDeliveryTimePeriod());

				}
			});
			return l2;
		} else {
			throw new NotFoundException("Retailer Inventory doesn't contain any data with productId = " + productId);
		}
	}

	/*******************************************************************
	 -FunctionName          : getCategoryWiseReportByCategoryId()
	 -Input Parameters      : int categoryNumber
	 -Return Type           : List<RetailerInventory2>
	 -Exception	name		: NotFoundException
	 -Author				: Keerthi Sree
	 -Creation Date			: 20/09/2020
	 -Description  			: To get the list of retailer inventory with
	 						  same category number
	*********************************************************************/
	@Override
	public List<RetailerInventory2> getCategoryWiseReportByCategoryId(int categoryNumber) {

		List<RetailerInventory2> l2 = new ArrayList<RetailerInventory2>();
		if (inventoryRepo.existsByCategoryNumber(categoryNumber)) {
			for (RetailerInventory ri : inventoryRepo.getCategoryWiseReportByCategoryId(categoryNumber)) {
				RetailerInventory2 f = new RetailerInventory2();
				f.setRetailerId(ri.getRetailerId());
				f.setProductUniqueId(ri.getProductUniqueId());
				f.setProductId(ri.getProductId());
				f.setProductCategoryNumber(ri.getProductCategoryNumber());
				f.setProductDispatchTimestamp(ri.getProductDispatchTimestamp());
				f.setProductReceiveTimestamp(ri.getProductRecieveTimestamp());
				f.setDeliveryTimePeriod(
						ChronoUnit.DAYS.between(ri.getProductDispatchTimestamp(), ri.getProductRecieveTimestamp()));
				l2.add(f);
			}
			Collections.sort(l2, new Comparator<RetailerInventory2>() {
				@Override
				public int compare(RetailerInventory2 u1, RetailerInventory2 u2) {

					return Long.compare(u1.getDeliveryTimePeriod(), u2.getDeliveryTimePeriod());

				}
			});
			return l2;
		} else {
			throw new NotFoundException(
					"Retailer Inventory doesn't contain any data with product category number = " + categoryNumber);
		}

	}

}
