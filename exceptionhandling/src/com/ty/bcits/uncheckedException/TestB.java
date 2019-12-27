package com.ty.bcits.uncheckedException;

public class TestB {
public static void main(String[] args) {
	String name=null;
	System.out.println("main started");
	try {
		try {
			System.out.println(100/0);
		}catch(ArithmeticException a){
			System.out.println(a.getMessage());
		}
		System.out.println(name.length());
	}
		catch(NullPointerException n) {
			System.out.println(n.getMessage());
		}
	
	System.out.println("main ended");
}
}

