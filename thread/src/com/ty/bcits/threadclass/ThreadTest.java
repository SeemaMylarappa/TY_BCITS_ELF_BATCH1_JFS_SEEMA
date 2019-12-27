package com.ty.bcits.threadclass;

public class ThreadTest {
public static void main(String[] args) {
	System.out.println("main started");
	Thread1 t1=new Thread1();
	Thread1 t2=new Thread1();
	t1.start();
	t2.start();
	
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
	}
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("main ended");
}
}
