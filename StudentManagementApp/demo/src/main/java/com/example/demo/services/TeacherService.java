package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.Student;
import com.example.demo.controllers.Teacher;
import com.example.demo.repos.TeacherDao;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao stu;
    
	public List<Teacher> allTeachers() {
		return stu.findAll();
	}
	
	public String addTeacher(Teacher teacher) {
		if(stu.existsById(teacher.getStd())) {
			return "Sorry the Teacher you entered already exists! Please try again with different std.";
		}
		stu.save(teacher);
		return "Teacher added successfully!";
	}
	
	public Optional<Teacher> specificTeacher(int std) {
		return stu.findById(std);
	}
}
