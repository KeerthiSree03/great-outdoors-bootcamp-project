package com.capgemini.go.deliverytimereports.model;

import java.util.List;

public class ItemLevelEntriesList {
	
	private List<ItemLevelEntry> list;

	public ItemLevelEntriesList(List<ItemLevelEntry> list) {
		super();
		this.list = list;
	}

	public ItemLevelEntriesList() {
		super();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((list == null) ? 0 : list.hashCode());
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
		ItemLevelEntriesList other = (ItemLevelEntriesList) obj;
		if (list == null) {
			if (other.list != null)
				return false;
		} else if (!list.equals(other.list))
			return false;
		return true;
	}

	public List<ItemLevelEntry> getList() {
		return list;
	}

	public void setList(List<ItemLevelEntry> list) {
		this.list = list;
	}

	
	
	

}
