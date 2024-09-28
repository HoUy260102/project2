package com.javaweb.repository.entity;

public class RentAreaEntity {
	private Integer value;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public RentAreaEntity(Integer value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return value.toString();
	}
	
}
