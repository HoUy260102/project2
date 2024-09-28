package com.javaweb.repository;

import java.util.List;
import java.util.Map;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(String name);
	List<BuildingEntity> find(Map<String, Object> param,
			List<String> rentType);
}
