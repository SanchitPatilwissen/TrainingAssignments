package com.example.demo;

public class NameException extends RuntimeException{
	NameException() {
        super();
    }

    NameException(String s) {
        super(s);
    }
}
