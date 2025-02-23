package com.example.demo.controllers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repos.StudentDao;
import com.example.demo.services.StudentService;
import com.example.demo.services.TeacherService;

@RestController
public class MyController {
	@Autowired
	private StudentService stu;
	@Autowired
	private TeacherService tea;
	
	@GetMapping(path="/students", produces="application/json")
	public List<Student> allStudents() {
		return stu.allStudents();
	}
	
	@PostMapping(path="/students/add", produces="application/json")
	public String addStudent(@RequestBody Student student) {
		return stu.addStudents(student);
	}
	
	@PostMapping(path="/teachers/add", produces="application/json")
	public String addTeacher(@RequestBody Teacher teacher) {
		return tea.addTeacher(teacher);
	}
	
	@GetMapping(path="/teachers", produces="application/json")
	public List<Teacher> allTeachers() {
		return tea.allTeachers();
	}
	
	@GetMapping(path="/students/class_teacher", produces="application/json")
	public Optional<Teacher> getTeacherByRegNo(int regNo) {
		Optional<Student> student = stu.specificStudent(regNo);
		if(student.get()==null)
			return null;
		int std = student.get().getStd();
		return tea.specificTeacher(std);
	}
	
	@GetMapping(path="/", produces="text/html")
	public String abc() {
		return stu.abc();
	}
	
	@GetMapping(path="/student/{rollno}", produces="application/json")
	public Optional<Student> specificStudent(@PathVariable int rollno) {
		return stu.specificStudent(rollno);
	}
	
	@GetMapping("/students/school")
	public List<Student> studentSchool(@RequestParam String name) {
		return stu.studentSchool(name);
	}
	
	@GetMapping("/students/result")
	public List<Student> passedFailStudents(@RequestParam boolean pass) {
		return stu.passedFailStudents(pass);
	}
	
	@GetMapping(path="/students/{std}/count", produces="application/json")
	public int studentNumberStd(@PathVariable int std) {
		return stu.studentNumberStd(std);
	}
	
	@GetMapping("/students/strength")
	public int schoolStrength(@RequestParam String school) {
		return stu.schoolStrength(school);
	}
	
	@GetMapping(path="/students/toppers", produces="application/json")
	public List<Student> topFivePercent() {
		return stu.topFivePercent();
	}
	
	@GetMapping(path="/students/topper/{std}", produces="application/json")
	public List<Student> standardWiseTopper(@PathVariable int std) {
		return stu.standardWiseTopper(std);
	}
	
}

/*
 Student
--------
rollNo
name
standard
school
percentage
 
 
/students			 - get all students
/student/rollNo			 - get specific student with given rollNo
/students/school?name=DPS	 - get all students of that school
/students/result?pass=true/false - all students above 40% / below 40%
/students/5/count		 - how many students in 5th standard
/students/strength?school=DPS	 - total strength for given school name
/students/toppers		 - top 5 percentage students
/students/topper/3		 - topper of 3rd standard 
 */
