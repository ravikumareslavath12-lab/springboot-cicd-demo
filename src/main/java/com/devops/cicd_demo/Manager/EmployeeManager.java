package com.devops.cicd_demo.Manager;

import org.springframework.stereotype.Repository;

import com.devops.cicd_demo.Entity.EmployeeMasterEntity;
import com.devops.cicd_demo.common.GenericManager;

@Repository
public class EmployeeManager extends GenericManager<EmployeeMasterEntity, Long> {

	public EmployeeManager() {
		super(EmployeeMasterEntity.class);
	}
}
