package com.ty.bcits.ExceptionPropogation;

public class TestMain {
public static void main(String[] args) {
	System.out.println("main started");
	try {
		TestA.a();
	}catch(ArithmeticException a) {
		System.out.println(a.getMessage());
	}
	System.out.println("main ended");
}
}
