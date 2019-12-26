package com.ty.bcits.PriorityQueue;

import java.util.PriorityQueue;

public class Priority {
public static void main(String[] args) {
	PriorityQueue<Integer> p1=new PriorityQueue<Integer>();
	p1.add(23);
	p1.add(1);
	p1.add(85);
	p1.add(54);
	p1.add(25);
	p1.add(62);
	p1.add(23);
	//p1.add(null);
	System.out.println(p1);
	p1.remove();
	System.out.println(p1);
	p1.remove();
	System.out.println(p1);
}
}
