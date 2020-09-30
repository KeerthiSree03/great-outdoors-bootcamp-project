package com.capgemini.go.user.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RetailerInventory2 {

	
	private String retailerId;
	private int productCategoryNumber;
	private String productId;
	@Id
	private String productUniqueId;
	private LocalDate productDispatchTimestamp;
	private LocalDate productReceiveTimestamp;
	private long deliveryTimePeriod;
	
	
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
	public LocalDate getProductReceiveTimestamp() {
		return productReceiveTimestamp;
	}
	public void setProductReceiveTimestamp(LocalDate productReceiveTimestamp) {
		this.productReceiveTimestamp = productReceiveTimestamp;
	}
	public long getDeliveryTimePeriod() {
		return deliveryTimePeriod;
	}
	public void setDeliveryTimePeriod(long deliveryTimePeriod) {
		this.deliveryTimePeriod = deliveryTimePeriod;
	}
	@Override
	public String toString() {
		return "RetailerInventory2 [retailerId=" + retailerId + ", productCategoryNumber=" + productCategoryNumber
				+ ", productId=" + productId + ", productUniqueId=" + productUniqueId + ", productDispatchTimestamp="
				+ productDispatchTimestamp + ", productReceiveTimestamp=" + productReceiveTimestamp
				+ ", deliveryTimePeriod=" + deliveryTimePeriod + "]";
	}
	public RetailerInventory2() {
		super();
	}
	public RetailerInventory2(String retailerId, int productCategoryNumber, String productId, String productUniqueId,
			LocalDate productDispatchTimestamp, LocalDate productReceiveTimestamp, long deliveryTimePeriod) {
		super();
		this.retailerId = retailerId;
		this.productCategoryNumber = productCategoryNumber;
		this.productId = productId;
		this.productUniqueId = productUniqueId;
		this.productDispatchTimestamp = productDispatchTimestamp;
		this.productReceiveTimestamp = productReceiveTimestamp;
		this.deliveryTimePeriod = deliveryTimePeriod;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (deliveryTimePeriod ^ (deliveryTimePeriod >>> 32));
		result = prime * result + productCategoryNumber;
		result = prime * result + ((productDispatchTimestamp == null) ? 0 : productDispatchTimestamp.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productReceiveTimestamp == null) ? 0 : productReceiveTimestamp.hashCode());
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
		RetailerInventory2 other = (RetailerInventory2) obj;
		if (deliveryTimePeriod != other.deliveryTimePeriod)
			return false;
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
	

	
	
	

}
