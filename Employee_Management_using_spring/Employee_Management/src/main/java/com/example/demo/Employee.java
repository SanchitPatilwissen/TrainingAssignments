package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class Employee {
	
	private int emp_id;
	@Value("Admin")
    private String name;
	@Value("21")
    private int age;
	@Value("25000.00")
    double salary;
	@Value("CLERK")
    private Designation designation;
    @Autowired
    private Address address;

    Employee(String var1, int var2, double var3, Designation var4, int var5) throws Exception {

        this.name = var1;
        this.age = var2;
        this.salary = var3;
        this.designation = var4;
        this.emp_id = var5;
    }

    final int getId() {
        return this.emp_id;
    }

    final String getName() {
        return this.name;
    }

    final double getSalary() {
        return this.salary;
    }

    final int getAge() {
        return this.age;
    }

    final Designation getDesignation() {
        return this.designation;
    }

    final void display() {
        System.out.println("The following are the details of this Employee : \nName : " + this.name + "\nAge : "
                + this.age + "\nSalary : " + this.salary + "\nDesignation : " + this.designation);
    }

    abstract void raiseSalary();
}
