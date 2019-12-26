package com.ty.bcits.LinkedList;

import java.util.LinkedList;

public class LinkedListMeths {
public static void main(String[] args) {
	LinkedList<Integer> l1=new LinkedList<Integer>();
	l1.add(88);
	l1.add(98);
	l1.add(82);
	System.out.println(l1);
	l1.add(0, 85);
	System.out.println(l1);
	System.out.println(l1.contains(88));
	l1.remove(0);
	System.out.println(l1);

	LinkedList<Integer> l2=new LinkedList<Integer>();
	l2.add(54);
	l2.add(98);
	l2.add(90);
	System.out.println(l2.containsAll(l1));
	
	
	

}
}
