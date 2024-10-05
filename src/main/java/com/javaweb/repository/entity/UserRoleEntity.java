//package com.javaweb.repository.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "user_role")
//public class UserRoleEntity {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "roleid")
//	private RoleEntity role;
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "userid")
//	private UserEntity user;
//	public RoleEntity getRole() {
//		return role;
//	}
//	public void setRole(RoleEntity role) {
//		this.role = role;
//	}
//	public UserEntity getUser() {
//		return user;
//	}
//	public void setUser(UserEntity user) {
//		this.user = user;
//	}
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//}
