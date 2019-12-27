package com.ty.bcits.checkedException;

public class Calculator {
	String nsme;
	void division(int a,int b) {
		try {
			Class.forName("Person");
		}catch(ClassNotFoundException c) {
			System.out.println("class not found");
		}
	}
}
