package com.example.demo.entities.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping(path="/employees/{id}", produces="application/json")
	public Optional<Employee> getEmployee(@PathVariable int id) {
		return emp.getEmployee(id);
	}
	
	@PostMapping(path="/employees/add", produces="application/json")
	public String addEmployee(@RequestBody Employee employee) {
		return emp.addEmployee(employee);
	}
	
	@DeleteMapping(path="/employees/delete/{id}", produces="application/json")
	public String removeEmployee(@PathVariable int id) {
		return emp.removeEmployee(id);
	}
	
	@GetMapping(path="/employees/count", produces="application/json")
	public long getEmployeeSize() {
		return emp.getEmployeeSize();
	}
}
