package com.ty.bcits.Vector;

import java.util.Vector;

public class VectorMeths {
	public static void main(String[] args) {
		Vector<Integer> v1=new Vector<Integer>();
		v1.add(23);
		v1.add(65);
		v1.add(54);
		v1.add(null);
		
		System.out.println(v1);
		v1.setSize(4);
		System.out.println(v1);
		v1.remove(0);
		System.out.println(v1);
		System.out.println(v1.isEmpty());
		System.out.println(v1.size());
		System.out.println(v1.contains(44));
		System.out.println(v1.capacity());
		
		v1.insertElementAt(77, 2);
		System.out.println(v1);
		
		v1.removeElement(null);
		System.out.println(v1);
		
		v1.setElementAt(29, 0);
		System.out.println(v1);
		
		v1.trimToSize();//size and capacity will become same
		System.out.println(v1);
		
		v1.ensureCapacity(5);
	System.out.println(v1.capacity());
	}
}
