package com.capgemini.go.deliverytimereports.model;

public class ItemLevelEntry {

	private String productId;
	private int categoryNumber;
	private String productName;
	private long deliveryTimePeriod;

	public ItemLevelEntry() {
		super();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryNumber;
		result = prime * result + (int) (deliveryTimePeriod ^ (deliveryTimePeriod >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
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
		ItemLevelEntry other = (ItemLevelEntry) obj;
		if (categoryNumber != other.categoryNumber)
			return false;
		if (deliveryTimePeriod != other.deliveryTimePeriod)
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}


	public ItemLevelEntry(String productId, int categoryNumber, String productName, long deliveryTimePeriod) {
		super();
		this.productId = productId;
		this.categoryNumber = categoryNumber;
		this.productName = productName;
		this.deliveryTimePeriod = deliveryTimePeriod;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getDeliveryTimePeriod() {
		return deliveryTimePeriod;
	}

	public void setDeliveryTimePeriod(long deliveryTimePeriod) {
		this.deliveryTimePeriod = deliveryTimePeriod;
	}

	@Override
	public String toString() {
		return "ItemLevelEntry [productId=" + productId + ", categoryNumber=" + categoryNumber + ", productName="
				+ productName + ", deliveryTimePeriod=" + deliveryTimePeriod + "]";
	}

	
	
	

}
