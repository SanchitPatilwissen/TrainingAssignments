package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	static List<Student> students;
	
	static{
		students = new ArrayList<Student>();
		
		students.add(new Student(1, "Rishabh", 5, "DPS", 89));
		students.add(new Student(2, "Sania", 3, "BSS", 78));
		students.add(new Student(3, "Harry", 1, "KV", 23));
		students.add(new Student(4, "Ron", 2, "KV", 33));
		students.add(new Student(5, "Hemangi", 10, "DPS", 98));
		students.add(new Student(6, "Shaan", 8, "GSW", 71));
		students.add(new Student(7, "Shreya", 5, "Ryan", 42));
		students.add(new Student(8, "Aakash", 12, "DPS", 67));
		students.add(new Student(9, "Priya", 4, "BSS", 85));
		students.add(new Student(10, "Karan", 6, "GSW", 92));
		students.add(new Student(11, "Nisha", 7, "Ryan", 77));
		students.add(new Student(12, "Vikram", 6, "KV", 54));
		students.add(new Student(13, "Neha", 5, "DPS", 81));
		students.add(new Student(14, "Manish", 9, "Sapphire", 60));
		students.add(new Student(15, "Reena", 10, "Ryan", 95));
		students.add(new Student(16, "Sam", 12, "DPS", 65));
		students.add(new Student(17, "Sanya", 5, "BSS", 73));
		students.add(new Student(18, "Arjun", 8, "Sapphire", 83));
		students.add(new Student(19, "Mansi", 3, "KV", 74));
		students.add(new Student(20, "Kritika", 11, "Ryan", 88));
		students.add(new Student(21, "Siddharth", 6, "DPS", 90));
		students.add(new Student(22, "Amit", 7, "GSW", 79));
		students.add(new Student(23, "Tanvi", 4, "Sapphire", 69));
		students.add(new Student(24, "Ravi", 5, "Ryan", 77));
		students.add(new Student(25, "Neeraj", 9, "KV", 72));
		students.add(new Student(26, "Anjali", 7, "DPS", 65));
		students.add(new Student(27, "Vishal", 11, "Sapphire", 58));
		students.add(new Student(28, "Pooja", 4, "Ryan", 62));
		students.add(new Student(29, "Raj", 6, "BSS", 80));
		students.add(new Student(30, "Shivani", 5, "DPS", 93));
		students.add(new Student(31, "Sohail", 8, "GSW", 67));
		students.add(new Student(32, "Ritika", 7, "Sapphire", 75));
		students.add(new Student(33, "Aditya", 6, "Ryan", 81));
		students.add(new Student(34, "Madhavi", 10, "DPS", 96));
		students.add(new Student(35, "Tarun", 5, "Sapphire", 79));
		students.add(new Student(36, "Neelam", 7, "KV", 87));
		students.add(new Student(37, "Kunal", 8, "BSS", 88));
		students.add(new Student(38, "Pranjal", 11, "GSW", 61));
		students.add(new Student(39, "Tanya", 4, "Ryan", 66));
		students.add(new Student(40, "Rajesh", 9, "Sapphire", 74));
		System.out.println("Server started");
	}
	
	@GetMapping(path="/students", produces="application/json")
	public List<Student> allStudents() {
		return students;
	}
	
	@GetMapping(path="/", produces="text/html")
	public String abc() {
		return "<h1>Welcome to the website<h1>";
	}
	
	@GetMapping(path="/student/{rollno}", produces="application/json")
	public List<Student> specificStudent(@PathVariable int rollno) {
		List<Student> result = students.stream().filter(s -> s.getRollno()==rollno).collect(Collectors.toList());
		return result;
	}
	
	@GetMapping("/students/school")
	public List<Student> studentSchool(@RequestParam String name) {
		List<Student> result = students.stream().filter(s -> s.getSchool().equals(name)).collect(Collectors.toList());
		return result;
	}
	
	@GetMapping("/students/result")
	public List<Student> passedFailStudents(@RequestParam boolean pass) {
		List<Student> result;
		if(pass) {
			result = students.stream().filter(s -> s.getPercentage()>=40).collect(Collectors.toList());			
		}
		else {
			result = students.stream().filter(s -> s.getPercentage()<40).collect(Collectors.toList());
		}
		return result;
	}
	
	@GetMapping(path="/students/{std}/count", produces="application/json")
	public int studentNumberStd(@PathVariable int std) {
		List<Student> result = students.stream().filter(s -> s.getStd()==std).collect(Collectors.toList());
		return result.size();
	}
	
	@GetMapping("/students/strength")
	public int schoolStrength(@RequestParam String school) {
		List<Student> result = students.stream().filter(s -> s.getSchool().equals(school)).collect(Collectors.toList());
		return result.size();
	}
	
	@GetMapping(path="/students/toppers", produces="application/json")
	public List<Student> topFivePercent() {
		int sz = students.size();
		int top5 = (int)(0.2*sz);
		List<Student> result = students.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(top5).collect(Collectors.toList());
		return result;
	}
	
	@GetMapping(path="/students/topper/{std}", produces="application/json")
	public Student standardWiseTopper(@PathVariable int std) {
		Student result = students.stream().filter(s -> s.getStd()==std).max(Comparator.comparingDouble(Student::getPercentage)).get();
		return result;
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
