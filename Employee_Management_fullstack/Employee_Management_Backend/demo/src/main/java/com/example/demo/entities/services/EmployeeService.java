package com.example.demo.entities.services;

import java.util.List;
import java.util.Optional;

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
	
	public Optional<Employee> getEmployee(int id) {
		return emp.findById(id);
	}
	
	public String addEmployee(Employee employee) {
		emp.save(employee);
		return "Student added successfully!";
	}
	
	public String removeEmployee(int id) {
		if(!emp.existsById(id)) {
			return "Sorry the Student you entered doesn't exist! Please try again with different Id.";
		}
		else {
			emp.deleteById(id);
			return "Employee Deleted successfully";
		}
	}
	
	public long getEmployeeSize() {
		return emp.count();
	}
}
