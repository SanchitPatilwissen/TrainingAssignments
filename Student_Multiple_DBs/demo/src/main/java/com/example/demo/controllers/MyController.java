package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.primary.entities.Student;
import com.example.demo.primary.repos.StudentDao;
import com.example.demo.secondary.repos.StudentDao2;

@RestController
public class MyController {
	@Autowired
	StudentDao stu;
	StudentDao2 stu2;
	
	@GetMapping("/students")
	public Iterable<Student> getEmployees(){
		return stu.findAll();
	}
	
	@PostMapping("/students")
	public String addEmployees(@RequestBody Student e){
		if(stu.existsById(e.getRollNo())) {
			return "Sorry student with given ID already exists in DB1";
		}
		stu.save(e);
		if(stu2.existsById(e.getRollNo())){
			return "Sorry student with given ID already exists in DB2";
		}
		stu2.save(e);
		return "Added Student successfully!";
	}
}
