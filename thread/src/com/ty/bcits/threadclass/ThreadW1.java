package com.ty.bcits.threadclass;

public class ThreadW1 extends Thread{
  public synchronized void run() {
	  System.out.println("Thread started");
	  for (int i = 0; i < 5; i++) {
		System.out.println(i);
	}
	 try {
		wait();
	} catch (InterruptedException e) {
		System.out.println(e.getMessage());
	}
		
	}
  public synchronized void leaveMe() {
	  System.out.println("notify called");
	  notify();
  }
}

