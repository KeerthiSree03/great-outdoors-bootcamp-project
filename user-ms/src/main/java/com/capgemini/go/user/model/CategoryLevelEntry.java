package com.capgemini.go.user.model;

public class CategoryLevelEntry {

	private int categoryId;
	private String categoryName;
	private long deliveryTimePeriod;

	public CategoryLevelEntry() {
		super();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + categoryId;
		result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
		result = prime * result + (int) (deliveryTimePeriod ^ (deliveryTimePeriod >>> 32));
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
		CategoryLevelEntry other = (CategoryLevelEntry) obj;
		if (categoryId != other.categoryId)
			return false;
		if (categoryName == null) {
			if (other.categoryName != null)
				return false;
		} else if (!categoryName.equals(other.categoryName))
			return false;
		if (deliveryTimePeriod != other.deliveryTimePeriod)
			return false;
		return true;
	}


	public CategoryLevelEntry(int categoryId, String categoryName, long deliveryTimePeriod) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.deliveryTimePeriod = deliveryTimePeriod;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public long getDeliveryTimePeriod() {
		return deliveryTimePeriod;
	}

	public void setDeliveryTimePeriod(long deliveryTimePeriod) {
		this.deliveryTimePeriod = deliveryTimePeriod;
	}

	@Override
	public String toString() {
		return "CategoryLevelEntry [categoryId=" + categoryId + ", categoryName=" + categoryName
				+ ", deliveryTimePeriod=" + deliveryTimePeriod + "]";
	}

	
	
	

}
