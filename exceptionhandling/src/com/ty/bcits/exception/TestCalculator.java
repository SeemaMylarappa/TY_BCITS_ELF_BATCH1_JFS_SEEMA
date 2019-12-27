package com.ty.bcits.exception;

public class TestCalculator {
public static void main(String[] args) {
	System.out.println("main started");
	Calculator c1=new Calculator();
	c1.divison(200, 5);
	c1.divison(100, 0);
	c1.divison(20, 5);
	c1.divison(50, 2);
	
	System.out.println("main ended");
}
}
