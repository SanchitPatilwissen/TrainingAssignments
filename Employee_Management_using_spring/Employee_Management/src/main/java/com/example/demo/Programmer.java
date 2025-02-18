package com.example.demo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("prototype")
@Component
public final class Programmer extends Employee{
	Programmer(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 30000, designation, id);
    }

    void raiseSalary() {
        salary += 5000;
    }
}
