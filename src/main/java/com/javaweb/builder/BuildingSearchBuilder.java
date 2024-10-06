package com.javaweb.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

public class BuildingSearchBuilder {
	private String name;
	private Integer numberOfBasement;
	private String ward;
	private String street;
	private Integer floorArea;
	private String managerName;
	private String managerPhoneNumber;
	private Integer districtId;
	private Integer staffId;
	private Integer rentAreaFrom;
	private Integer rentAreaTo;
	private Integer rentPriceFrom;
	private Integer rentPriceTo;
	private List<String> rentType = new ArrayList<String>();
	private BuildingSearchBuilder(Builder builder) {
		this.name = builder.name;
		this.numberOfBasement = builder.numberOfBasement;
		this.ward = builder.ward;
		this.street = builder.street;
		this.floorArea = builder.floorArea;
		this.managerName = builder.managerName;
		this.managerPhoneNumber = builder.managerPhoneNumber;
		this.districtId = builder.districtId;
		this.staffId = builder.staffId;
		this.rentAreaFrom = builder.rentAreaFrom;
		this.rentAreaTo = builder.rentAreaTo;
		this.rentPriceFrom = builder.rentPriceFrom;
		this.rentPriceTo = builder.rentPriceTo;
		this.rentType = builder.rentType;
	}
	public String getName() {
		return name;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public String getWard() {
		return ward;
	}
	public String getStreet() {
		return street;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public String getManagerName() {
		return managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public Integer getDistrictId() {
		return districtId;
	}
	public Integer getStaffId() {
		return staffId;
	}
	public Integer getRentAreaFrom() {
		return rentAreaFrom;
	}
	public Integer getRentAreaTo() {
		return rentAreaTo;
	}
	public Integer getRentPriceFrom() {
		return rentPriceFrom;
	}
	public Integer getRentPriceTo() {
		return rentPriceTo;
	}
	public List<String> getRentType() {
		return rentType;
	}
	public static class Builder {
		private String name;
		private Integer numberOfBasement;
		private String ward;
		private String street;
		private Integer floorArea;
		private String managerName;
		private String managerPhoneNumber;
		private Integer districtId;
		private Integer staffId;
		private Integer rentAreaFrom;
		private Integer rentAreaTo;
		private Integer rentPriceFrom;
		private Integer rentPriceTo;
		private List<String> rentType = new ArrayList<String>();
		public Builder setRentType(List<String> rentType) {
			this.rentType = rentType;
			return this;
		}
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setNumberOfBasement(Integer numberOfBasement) {
			this.numberOfBasement = numberOfBasement;
			return this;
		}
		public Builder setWard(String ward) {
			this.ward = ward;
			return this;
		}
		public Builder setStreet(String street) {
			this.street = street;
			return this;
		}
		public Builder setFloorArea(Integer floorArea) {
			this.floorArea = floorArea;
			return this;
		}
		public Builder setManagerName(String managerName) {
			this.managerName = managerName;
			return this;
		}
		public Builder setManagerPhoneNumber(String managerPhoneNumber) {
			this.managerPhoneNumber = managerPhoneNumber;
			return this;
		}
		public Builder setDistrictId(Integer districtId) {
			this.districtId = districtId;
			return this;
		}
		public Builder setStaffId(Integer staffId) {
			this.staffId = staffId;
			return this;
		}
		public Builder setRentAreaFrom(Integer rentAreaFrom) {
			this.rentAreaFrom = rentAreaFrom;
			return this;
		}
		public Builder setRentAreaTo(Integer rentAreaTo) {
			this.rentAreaTo = rentAreaTo;
			return this;
		}
		public Builder setRentPriceFrom(Integer rentPriceFrom) {
			this.rentPriceFrom = rentPriceFrom;
			return this;
		}
		public Builder setRentPriceTo(Integer rentPriceTo) {
			this.rentPriceTo = rentPriceTo;
			return this;
		}
		public BuildingSearchBuilder build() {
			return new BuildingSearchBuilder(this);
		}
	}
}
