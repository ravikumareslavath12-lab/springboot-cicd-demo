package com.devops.cicd_demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_EMPLOYEE_MASTER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeMasterEntity extends BaseEntity {
	private static final long serialVersionUID = 1L;

	public EmployeeMasterEntity() {

	}

	public EmployeeMasterEntity(Long id) {
		this.id = id;
	}

	public EmployeeMasterEntity(String id) {
		this.id = Long.parseLong(id);
	}

	@Column(name = "NAME")
	private String name;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "VILLAGE")
	private String village;

	@Column(name = "PINCODE")
	private String pincode;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
}