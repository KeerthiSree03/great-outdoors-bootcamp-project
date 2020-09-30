package com.capgemini.go.deliverytimereports.model;

import java.util.List;

public class RetailerInventoryList {
	

	private List<RetailerInventory2> rIlist;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rIlist == null) ? 0 : rIlist.hashCode());
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
		RetailerInventoryList other = (RetailerInventoryList) obj;
		if (rIlist == null) {
			if (other.rIlist != null)
				return false;
		} else if (!rIlist.equals(other.rIlist))
			return false;
		return true;
	}
	
	public RetailerInventoryList() {
		super();
	}

	public RetailerInventoryList(List<RetailerInventory2> rIlist) {
		super();
		this.rIlist = rIlist;
	}

	public List<RetailerInventory2> getrIlist() {
		return rIlist;
	}

	public void setrIlist(List<RetailerInventory2> rIlist) {
		this.rIlist = rIlist;
	}

	@Override
	public String toString() {
		return "RetailerInventoryList [rIlist=" + rIlist + "]";
	}

	

	
}
