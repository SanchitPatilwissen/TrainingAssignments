package com.example.demo.controllers;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	private int univRegNo;
	private int rollno;
	private String name;

	private int std;
	private String school;
	private double percentage;

	static Student getStudent(int univRegNo, int rollno, String name, String school, int std, double percentage) {
		Student stu = new Student();
		stu.univRegNo = univRegNo;
		stu.rollno = rollno;
		stu.name = name;
		stu.std = std;
		stu.school = school;
		stu.percentage = percentage;
		return stu;
	}
	
	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStd() {
		return std;
	}

	public void setStd(int std) {
		this.std = std;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public int getUnivRegNo() {
		return univRegNo;
	}

	public void setUnivRegNo(int univRegNo) {
		this.univRegNo = univRegNo;
	}
	
	
}
