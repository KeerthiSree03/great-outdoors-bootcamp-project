package com.capgemini.go.user.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RetailerInventory {

	private String retailerId;
	private int productCategoryNumber;
	private String productId;
	@Id
	private String productUniqueId;
	private LocalDate productDispatchTimestamp;
	private LocalDate productReceiveTimestamp;
	private LocalDate productSaleTimestamp;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + productCategoryNumber;
		result = prime * result + ((productDispatchTimestamp == null) ? 0 : productDispatchTimestamp.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productReceiveTimestamp == null) ? 0 : productReceiveTimestamp.hashCode());
		result = prime * result + ((productSaleTimestamp == null) ? 0 : productSaleTimestamp.hashCode());
		result = prime * result + ((productUniqueId == null) ? 0 : productUniqueId.hashCode());
		result = prime * result + ((retailerId == null) ? 0 : retailerId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetailerInventory other = (RetailerInventory) obj;
		if (productCategoryNumber != other.productCategoryNumber)
			return false;
		if (productDispatchTimestamp == null) {
			if (other.productDispatchTimestamp != null)
				return false;
		} else if (!productDispatchTimestamp.equals(other.productDispatchTimestamp))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productReceiveTimestamp == null) {
			if (other.productReceiveTimestamp != null)
				return false;
		} else if (!productReceiveTimestamp.equals(other.productReceiveTimestamp))
			return false;
		if (productSaleTimestamp == null) {
			if (other.productSaleTimestamp != null)
				return false;
		} else if (!productSaleTimestamp.equals(other.productSaleTimestamp))
			return false;
		if (productUniqueId == null) {
			if (other.productUniqueId != null)
				return false;
		} else if (!productUniqueId.equals(other.productUniqueId))
			return false;
		if (retailerId == null) {
			if (other.retailerId != null)
				return false;
		} else if (!retailerId.equals(other.retailerId))
			return false;
		return true;
	}
	
	
	public String getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	public int getProductCategoryNumber() {
		return productCategoryNumber;
	}
	public void setProductCategoryNumber(int productCategoryNumber) {
		this.productCategoryNumber = productCategoryNumber;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductUniqueId() {
		return productUniqueId;
	}
	public void setProductUniqueId(String productUniqueId) {
		this.productUniqueId = productUniqueId;
	}
	public LocalDate getProductDispatchTimestamp() {
		return productDispatchTimestamp;
	}
	public void setProductDispatchTimestamp(LocalDate productDispatchTimestamp) {
		this.productDispatchTimestamp = productDispatchTimestamp;
	}
	public LocalDate getProductRecieveTimestamp() {
		return productReceiveTimestamp;
	}
	public void setProductRecieveTimestamp(LocalDate productReceiveTimestamp) {
		this.productReceiveTimestamp = productReceiveTimestamp;
	}
	public LocalDate getProductSaleTimestamp() {
		return productSaleTimestamp;
	}
	public void setProductSaleTimestamp(LocalDate productSaleTimestamp) {
		this.productSaleTimestamp = productSaleTimestamp;
	}
	@Override
	public String toString() {
		return "RetailerInventory [retailerId=" + retailerId + ", productCategoryNumber=" + productCategoryNumber
				+ ", productId=" + productId + ", productUniqueId=" + productUniqueId + ", productDispatchTimestamp="
				+ productDispatchTimestamp + ", productReceiveTimestamp=" + productReceiveTimestamp
				+ ", productSaleTimestamp=" + productSaleTimestamp + "]";
	}
	public RetailerInventory(String retailerId, int productCategoryNumber, String productId, String productUniqueId,
			LocalDate productDispatchTimestamp, LocalDate productReceiveTimestamp, LocalDate productSaleTimestamp) {
		super();
		this.retailerId = retailerId;
		this.productCategoryNumber = productCategoryNumber;
		this.productId = productId;
		this.productUniqueId = productUniqueId;
		this.productDispatchTimestamp = productDispatchTimestamp;
		this.productReceiveTimestamp = productReceiveTimestamp;
		this.productSaleTimestamp = productSaleTimestamp;
	}
	public RetailerInventory() {
		super();
	}

	

	
	
	

}
