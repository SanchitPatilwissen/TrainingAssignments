package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("address")
@Scope("prototype")
public class Address {
	@Value("Mumbai")
	String city;
	@Value("Maharashtra")
	String state;
	@Value("400000")
	int pincode;
	String landmark;
	
	Address(String city, String state, int pincode, String landmark){
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.landmark = landmark;
	}
}
