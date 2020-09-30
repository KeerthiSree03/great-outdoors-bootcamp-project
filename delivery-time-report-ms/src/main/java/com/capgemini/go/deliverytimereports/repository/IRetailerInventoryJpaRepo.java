package com.capgemini.go.deliverytimereports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.go.deliverytimereports.model.RetailerInventory;

@Repository
public interface IRetailerInventoryJpaRepo extends JpaRepository<RetailerInventory, String> {
	
	@Query(value = "SELECT * FROM Retailer_Inventory r WHERE r.product_Category_Number = :categoryNumber", nativeQuery = true)
	public List<RetailerInventory> getCategoryWiseReportByCategoryId(int categoryNumber);
	
	@Query(value = "SELECT * FROM Retailer_Inventory p WHERE p.product_Id = :productId", nativeQuery = true)
	public List<RetailerInventory> getItemWiseReportByProductId(String productId);

	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM RetailerInventory c WHERE c.productId = :productId")
	public boolean existsByProductId(String productId);
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM RetailerInventory c WHERE c.productCategoryNumber = :categoryId")
	public boolean existsByCategoryNumber(int categoryId);
	
}
