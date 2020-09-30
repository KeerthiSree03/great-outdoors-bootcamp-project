package com.capgemini.go.deliverytimereports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.go.deliverytimereports.model.Product;

public interface IProductJpaRepo extends JpaRepository<Product, String> {

	@Query(value = "SELECT * FROM Product p WHERE p.category_Id = :categoryNumber", nativeQuery = true)
	public List<Product> getListByCategoryNumber(int categoryNumber);
	
	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Product c WHERE c.categoryId = :categoryId")
	public boolean existsByCategoryId(int categoryId);
	
}
