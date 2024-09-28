package com.javaweb.repository.entity;

public class DistrictEntity {
	private String name;
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public DistrictEntity(Integer id, String name) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "DistrictEntity [name=" + name + ", id=" + id + "]";
	}
	
}
