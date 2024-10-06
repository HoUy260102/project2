package com.javaweb.api;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.model.BuildingDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.service.BuildingService;

@RestController
@PropertySource("classpath:application.properties")
public class BuildingAPI {
	@Autowired
	private BuildingService buildingService;
	@Autowired
	private BuildingRepository buildingRepository;
	@GetMapping(value="/api/building/")
//	public List<BuildingDTO> getBuilding(@RequestParam(value = "name") String name){
//		List<BuildingDTO> result = buildingService.findAll(name);
//		return result;
//	}
	public List<BuildingDTO> getBuilding(@RequestParam Map<String, Object> param,
			@RequestParam(value="rentType", required = false) List<String> rentType) {
		List<BuildingDTO> buildingDTO = buildingService.find(param, rentType);
		return buildingDTO;
	}
	
//	public void valiDate(BuildingDTO building) throws FieldRequiredException {
//		if (building.getName().equals("")||building.getName()==null||
//			building.getNumberOfBasement()==null) {
//			throw new FieldRequiredException("name or numberofbasement is null");
//		} 
//	}
	@RequestMapping(value="/api/building/", method = RequestMethod.POST)
	public void getBuilding2(@RequestBody BuildingDTO buildingDTO) {
		System.out.println(buildingDTO.getName());
	}
//	@Value("${dev.nguyen}")
//	private String data;
	@DeleteMapping(value = "/api/building/{id}")
	public BuildingEntity delete(@PathVariable Long id) {
//		BuildingEntity buildingEntities = buildingRepository.findById(id).get();
		return null;
	}
	
}
