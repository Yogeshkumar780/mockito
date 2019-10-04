package com.techprimers.test.testcontrollerexample;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestControllerExampleApplication {

	private static int count = 0;;

	public static void removeduplicate(String s) {

	/*	System.out.println("enter num1");
		Scanner sc = new Scanner(System.in);
		Integer num1 = sc.nextInt();
		System.out.println("enter num 2");
		Scanner sc2 = new Scanner(System.in);
		Integer num2 = sc.nextInt(); */
		boolean flag = true;

		for (int i = 2; i <= 10; i++) {
			for (int j = i-1; j < i; j++) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				System.out.println(i);
			}
		}

	}

	public static void main(String[] args) {
		removeduplicate("yayaa");

	}

}
