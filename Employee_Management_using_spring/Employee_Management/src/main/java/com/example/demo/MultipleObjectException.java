package com.example.demo;

import org.springframework.stereotype.Component;

@Component("MultipleObjectException")
public class MultipleObjectException extends RuntimeException {
	MultipleObjectException() {
        super();
    }

    MultipleObjectException(String s) {
        super(s);
    }
}
