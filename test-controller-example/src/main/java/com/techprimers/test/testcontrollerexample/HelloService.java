package com.techprimers.test.testcontrollerexample;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

	public String getData() {
		
		return "Hello world";
	}

}
