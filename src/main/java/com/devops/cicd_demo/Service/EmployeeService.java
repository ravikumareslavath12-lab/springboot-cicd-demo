package com.devops.cicd_demo.Service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.devops.cicd_demo.Entity.EmployeeMasterEntity;
import com.devops.cicd_demo.Manager.EmployeeManager;
import com.devops.cicd_demo.Utils.DateUtils;
import com.devops.cicd_demo.dto.ResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class EmployeeService {

	public EmployeeService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired private EmployeeManager employeeManager;
	@Autowired private Environment appConfig;
	
	public ResponseDTO saveEmployee(HttpServletRequest request,String jsonData) {
		ResponseDTO resp = new ResponseDTO();
		try {
			JSONObject jsonObject = new JSONObject(jsonData);
			Long id = jsonObject.optLong("id");
			String name = jsonObject.optString("name");
			String mobile = jsonObject.optString("mobile");
			String village = jsonObject.optString("village");
			String pincode = jsonObject.optString("pincode");
			EmployeeMasterEntity employee = employeeManager.get(id);
			if(employee==null) {
				employee = new EmployeeMasterEntity();
				employee.setCreatedOn(DateUtils.getCurrentSystemTimestamp());
				employee.setStatus(true);
			}
			employee.setName(name);
			employee.setMobile(mobile);
			employee.setVillage(village);
			employee.setPincode(pincode);
			employeeManager.saveOrUpdate(employee);
			// Logic to save employee data
			resp.setStatusCode(Integer.parseInt(appConfig.getProperty("SUCCESS_CODE")));
			resp.setMessage(appConfig.getProperty("SUCCESS"));
			resp.setResponse(null); // You can set the actual response object here
		} catch (Exception e) {
			resp.setStatusCode(500);
			resp.setMessage("Error saving employee: " + e.getMessage());
			resp.setResponse(null);
		}
		return resp;
	}

}
