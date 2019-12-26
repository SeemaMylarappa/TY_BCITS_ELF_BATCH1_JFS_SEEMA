package com.ty.bcits.LinkedHashSet;

import java.util.LinkedHashSet;

public class LinkedhashSetMeth {
public static void main(String[] args) {
	LinkedHashSet<Integer> l1=new LinkedHashSet<Integer>();
	l1.add(23);
	l1.add(44);
	l1.add(12);
	System.out.println(l1);
	l1.add(25);
	System.out.println(l1);
	l1.add(null);
	System.out.println(l1);
	l1.add(23);
	System.out.println(l1);
}
}
