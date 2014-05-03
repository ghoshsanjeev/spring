package com.bt.nat.item;


public class ItemForm {


	private String itemType;
	
	private int ein;

	public int getEin() {
		return ein;
	}

	public void setEin(int ein) {
		this.ein = ein;
	}

	private int item;
	
	private String itemSerial;
	
	private String nextCheckDate;
	
	private String remarks;
	
	private int building;

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getItemSerial() {
		return itemSerial;
	}

	public void setItemSerial(String itemSerial) {
		this.itemSerial = itemSerial;
	}

	public String getNextCheckDate() {
		return nextCheckDate;
	}

	public void setNextCheckDate(String nextCheckDate) {
		this.nextCheckDate = nextCheckDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getBuilding() {
		return building;
	}

	public void setBuilding(int building) {
		this.building = building;
	}


}
