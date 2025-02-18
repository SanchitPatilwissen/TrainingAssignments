package com.example.demo;

import org.springframework.stereotype.Component;

@Component("Ceo")
public final class Ceo extends Employee{
	Ceo(String name, int age, Designation designation, int id) throws Exception {
        super(name, age, 20000, designation, id);
    }

    void raiseSalary() {
        salary += 2000;
    }
}
