package com.ty.bcits.threadclass;

public class Thread1 extends Thread{
public void run() {
	System.out.println("Thread is called");
	for (int i = 0; i <= 5; i++) {
		System.out.println(i);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
}
