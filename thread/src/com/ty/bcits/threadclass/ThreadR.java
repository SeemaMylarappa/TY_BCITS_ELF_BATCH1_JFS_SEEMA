package com.ty.bcits.threadclass;

public class ThreadR implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread is started");
		for (int i = 0; i <5; i++) {
			System.out.println(i);
		}
	}

}
