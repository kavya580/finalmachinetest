package com.faith.model;

public class Vendor {

	// instance variables
	private int vId;
	private String vName;
	private String vAddress;
	private String vLocation;
	private String vService;
	private double pincode;
	private String isActive;

	// default constructor

	public Vendor() {
		super();
	}

	// getters and setters

	public int getvId() {
		return vId;
	}

	public void setvId(int vId) {
		this.vId = vId;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public String getvAddress() {
		return vAddress;
	}

	public void setvAddress(String vAddress) {
		this.vAddress = vAddress;
	}

	public String getvLocation() {
		return vLocation;
	}

	public void setvLocation(String vLocation) {
		this.vLocation = vLocation;
	}

	public String getvService() {
		return vService;
	}

	public void setvService(String vService) {
		this.vService = vService;
	}

	public double getPincode() {
		return pincode;
	}

	public void setPincode(double pincode) {
		this.pincode = pincode;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
