package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.employees"})
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		BeanFactory factory = SpringApplication.run(EmployeeManagementApplication.class, args);
		try {			
			Main.main(args, factory);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
