package com.devops.cicd_demo.Controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devops.cicd_demo.Service.EmployeeService;
import com.devops.cicd_demo.dto.ResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("rest/")
public class HelloController {
	private static final Logger LOG = LogManager.getLogger(HelloController.class);
	public HelloController() {
		// TODO Auto-generated constructor stub
	}
	@Autowired private DataSource dataSource;
	@Autowired private EmployeeService employeeService;
	
	@GetMapping("hello")
	public String Hello() {
		System.out.println("Hello");
		return "Hello! CI/CD Pipeline is working!";
	}
	@GetMapping("test")
	public String test() {
		System.out.println("Am integrated GitHub Actions in my springBoot application for Auto deploy code changes");
		return "Am integrated GitHub Actions in my springBoot application for Auto deploy code changes";
	}

	@GetMapping("/db-check")
	public String dbCheck() {
	    try (Connection connection = dataSource.getConnection()) {
	        return "Database Connected: " + connection.getCatalog();
	    } catch (Exception e) {
	        return "Database Connection Failed: " + e.getMessage();
	    }
	}
	@PostMapping("SaveEmployee")
	public ResponseDTO SaveEmployee(HttpServletRequest request,@RequestBody String jsonData) {
		ResponseDTO resp = new ResponseDTO();
		try {
			resp= employeeService.saveEmployee(request,jsonData);
		}catch(Exception e) {
			LOG.info("+++++"+e.getStackTrace(),e);
		}
		return resp;
	}
}
