package com.ty.bcits.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorMeth {
public static void main(String[] args) {
	ArrayList<Integer> a1=new ArrayList<Integer>();
	a1.add(25);
	a1.add(46);
	System.out.println("-----------using for loop---------");
	for (int i = 0; i < a1.size(); i++) {
		System.out.println(a1.get(i));
	}
	System.out.println("-----------using for each loop---------");
	Iterator<Integer> itr=a1.iterator();
	for (Integer integer : a1) {
		System.out.println(integer);
	}
	
	
	System.out.println("-----------iterator in forward direction---------");
	ListIterator<Integer> ltr=a1.listIterator();
	while (ltr.hasNext()) {
		System.out.println(ltr.next());
		
	}
	System.out.println("----------iterator in backward direction----------");
	ListIterator<Integer> ltr1=a1.listIterator(a1.size());
	while (ltr1.hasPrevious()) {
		System.out.println(ltr1.previous());
		//a1.add(23);//concurrent modification exception
}
}
}
