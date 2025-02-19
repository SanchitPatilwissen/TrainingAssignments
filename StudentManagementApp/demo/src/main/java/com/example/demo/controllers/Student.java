package com.example.demo.controllers;

public class Student {
	private int rollno;
	private String name;
	private int std;
	private String school;
	private double percentage;
	
	public Student(int rollno, String name, int std, String school, double percentage) {
		this.rollno = rollno;
		this.name = name;
		this.std = std;
		this.school = school;
		this.percentage = percentage;
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
	
	
}
