package com.javaweb.service;

import java.util.List;
import java.util.Map;

import com.javaweb.model.BuildingDTO;

public interface BuildingService {
	List<BuildingDTO> findAll(String name);
	List<BuildingDTO> find(Map<String, Object> param,
			List<String> rentType);
}
