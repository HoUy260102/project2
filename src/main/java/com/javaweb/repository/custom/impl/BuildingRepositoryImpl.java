//package com.javaweb.repository.custom.impl;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import org.springframework.stereotype.Repository;
//
//import com.javaweb.builder.BuildingSearchBuilder;
//import com.javaweb.repository.entity.BuildingEntity;
////@Repository
//public class BuildingRepositoryImpl{
//	
////	@Override
//	public List<BuildingEntity> findAll(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	@PersistenceContext 
//    private EntityManager entityManager;
//	
////	@Override
//	public List<BuildingEntity> find(BuildingSearchBuilder buildingSearchBuilder) {
//		// TODO Auto-generated method stub
//		String sql = "FROM BuildingEntity b";
//		Query query = entityManager.createQuery(sql, BuildingEntity.class);
//		return query.getResultList();
//	}
//	
//}
