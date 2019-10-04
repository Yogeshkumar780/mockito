package com.techprimers.test.testcontrollerexample;

import java.awt.PageAttributes.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloResource {

	private HelloService helloService;

	public HelloResource(HelloService helloService) {
		this.helloService = helloService;
	}

	@GetMapping
	public String get() {
		return helloService.getData();
	}

	@GetMapping(value = "/json",consumes="application/json", produces = "application/json")
	public Hello getJson() {

		return new Hello("Greetings", "Hello world");
	}
	
	@PostMapping(value="/post",consumes="application/json")
	public Hello postJson(@RequestBody Hello hello)
	{
		return hello;
	}

	public static class Hello {
		private String title;
		private String value;
		
		

		public Hello() {
			super();
		}

		public Hello(String title, String value) {
			super();
			this.title = title;
			this.value = value;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

}
