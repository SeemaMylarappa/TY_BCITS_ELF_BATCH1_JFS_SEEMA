package com.ty.bcits.threadclass;

public class ThreadR2 {
public static void main(String[] args) {
	System.out.println("main started");
	ThreadR t1=new ThreadR();
	ThreadR t2=new ThreadR();
	Thread t3=new Thread(t1);
	Thread t4=new Thread(t2);
	t3.start();
}
}
