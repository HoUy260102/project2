package com.javaweb.converter;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;

@Component
public class BuildingDTOConverter {
	@Autowired
	private DistrictRepository districtRepository;
	@Autowired
	private RentAreaRepository rentAreaRepository;
	@Autowired
	private ModelMapper modelMapper;
	public BuildingDTO toBuildingDTO(BuildingEntity item) {
		BuildingDTO building = modelMapper.map(item, BuildingDTO.class);
		building.setAddress(item.getStreet()+" "+item.getWard()+" "+districtRepository.getNameById(item.getDistrictId()));
		String listRentArea = rentAreaRepository.getValueById(item.getId()).stream().map(it -> it.getValue().toString()).collect(Collectors.joining(","));
		building.setListRentArea(listRentArea);
//		building.setName(item.getName());
//		building.setNumberOfBasement(item.getNumberOfBasement());
//		building.setFloorArea(item.getFloorArea());
//		building.setRentPrice(item.getRentPrice());
//		building.setManagerName(item.getManagerName());
//		building.setManagerPhoneNumber(item.getManagerPhoneNumber());
//		building.setServiceFee(item.getServiceFee());
//		building.setBrokerAgeFee(item.getBrokerAgeFee());
		return building;
	}
}
