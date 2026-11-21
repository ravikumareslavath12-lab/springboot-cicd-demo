package com.devops.cicd_demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest/")
public class HelloController {

	public HelloController() {
		// TODO Auto-generated constructor stub
	}
	@GetMapping("hello")
	public String Hello() {
		System.out.println("Hello");
		return "Hello! CI/CD Pipeline is working!";
	}

}
