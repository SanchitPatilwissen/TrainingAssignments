package com.example.demo.entities.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.repos.EmployeeDao;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao emp;
	
	public List<Employee> allEmployees() {
		return emp.findAll();
	}
	
	public String addEmployee(Employee employee) {
		if(emp.existsById(employee.getId())) {
			return "Sorry the Student you entered already exists! Please try again with different University registration number.";
		}
		emp.save(employee);
		return "Student added successfully!";
	}
}
