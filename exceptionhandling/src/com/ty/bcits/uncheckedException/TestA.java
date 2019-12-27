package com.ty.bcits.uncheckedException;

import javax.crypto.AEADBadTagException;

public class TestA {
	
public static void main(String[] args) {
	String name=null;
	System.out.println("main started");
	try {
		System.out.println(name.length());
		System.out.println(10/0);
		
	}catch(ArithmeticException | NullPointerException a) {
		System.out.println(a.getMessage());
	}
	System.out.println("main ended");
}
}
