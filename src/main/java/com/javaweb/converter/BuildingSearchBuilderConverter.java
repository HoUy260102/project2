package com.javaweb.converter;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.javaweb.Utils.MapUtil;
import com.javaweb.builder.BuildingSearchBuilder;
@Component
public class BuildingSearchBuilderConverter {
	public BuildingSearchBuilder toBuildingSearchBuilder(Map<String, Object> param, List<String> rentType) {
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder().setName(MapUtil.getObject(param, "name", String.class))
				.setDistrictId(MapUtil.getObject(param, "districtId", Integer.class))
				.setFloorArea(MapUtil.getObject(param, "floorArea", Integer.class))
				.setNumberOfBasement(MapUtil.getObject(param, "numberOfBasement", Integer.class))
				.setWard(MapUtil.getObject(param, "ward", String.class))
				.setStreet(MapUtil.getObject(param, "street", String.class))
				.setManagerName(MapUtil.getObject(param, "managerName", String.class))
				.setManagerPhoneNumber(MapUtil.getObject(param, "managerPhoneNumber", String.class))
				.setStaffId(MapUtil.getObject(param, "staffId", Integer.class))
				.setRentAreaFrom(MapUtil.getObject(param, "rentAreaFrom", Integer.class))
				.setRentAreaTo(MapUtil.getObject(param, "rentAreaTo", Integer.class))
				.setRentPriceFrom(MapUtil.getObject(param, "rentPriceFrom", Integer.class))
				.setRentPriceTo(MapUtil.getObject(param, "rentPriceTo", Integer.class))
				.setRentType(rentType)
				.build();
		return buildingSearchBuilder;
	}
}
