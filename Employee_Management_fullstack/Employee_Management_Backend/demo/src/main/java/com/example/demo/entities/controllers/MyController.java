package com.example.demo.entities.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.entities.services.EmployeeService;

@RestController
@CrossOrigin(origins="*")
public class MyController {
	@Autowired
	private EmployeeService emp;
	
	@GetMapping(path="/employees", produces="application/json")
	public List<Employee> allEmployees() {
		return emp.allEmployees();
	}
	
	@PostMapping(path="/employees/add", produces="application/json")
	public String addEmployee(@RequestBody Employee employee) {
		return emp.addEmployee(employee);
	}
}
