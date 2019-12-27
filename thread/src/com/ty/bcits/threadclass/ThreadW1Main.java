package com.ty.bcits.threadclass;

public class ThreadW1Main {
 public static void main(String[] args) {
	System.out.println("main started");
	ThreadW1 t1=new ThreadW1();
	ThreadW1 t2=new ThreadW1();
	t1.start();
	
	t2.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	t1.leaveMe();
	t2.leaveMe();
	System.out.println("main ended");
	
}
}
