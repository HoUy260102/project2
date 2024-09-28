package com.javaweb.model;

public class BuildingDTO {
	private String name;
	private Integer numberOfBasement;
	private String address;
	private Integer floorArea;
	private Integer rentPrice;
	private String managerName;
	private String managerPhoneNumber;
	private String serviceFee;
	private Double brokerAgeFee;
	private String listRentArea = "";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Double getBrokerAgeFee() {
		return brokerAgeFee;
	}
	public void setBrokerAgeFee(Double brokerAgeFee) {
		this.brokerAgeFee = brokerAgeFee;
	}
	public String getListRentArea() {
		return listRentArea;
	}
	public void setListRentArea(String listRentArea) {
		this.listRentArea = listRentArea;
	}
	
}
