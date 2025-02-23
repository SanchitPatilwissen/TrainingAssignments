package com.example.demo.services;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.controllers.Student;
import com.example.demo.repos.StudentDao;

@Service
public class StudentService {
	@Autowired
	private StudentDao stu;
    
	public List<Student> allStudents() {
		return stu.findAll();
	}
	
	public String addStudents(Student student) {
		if(stu.existsById(student.getUnivRegNo())) {
			return "Sorry the Student you entered already exists! Please try again with different University registration number.";
		}
		stu.save(student);
		return "Student added successfully!";
	}
	
	public String abc() {
		return "<h1>Welcome to the website<h1>";
	}
	
	public Optional<Student> specificStudent(int rollno) {
		return stu.findById(rollno);
	}
	
	public List<Student> studentSchool(String name) {
		return stu.findBySchool(name);
	}
	
	public List<Student> passedFailStudents(boolean pass) {
		if(pass) {
			return stu.findByPercentageGreaterThan(40);
		}
		else {
			return stu.findByPercentageLessThan(40);			
		}
	}
	
	public int studentNumberStd(int std) {
		return stu.findByStd(std).size();
	}
	
	public int schoolStrength(String school) {
		return stu.findBySchool(school).size();
	}
	
	public List<Student> topFivePercent() {
		long sz = stu.count();
		int top5 = (int)(0.05*sz);
		return stu.findtopFivePercent(top5);
	}
	
	public List<Student> standardWiseTopper(int std) {
		return stu.findstandardWiseTopper(std);
	}
}
