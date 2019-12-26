package com.ty.bcits.HashSet;

import java.util.HashSet;

public class HashSet1 {
public static void main(String[] args) {
	HashSet<Integer> hs=new HashSet<Integer>();
	hs.add(21);
	hs.add(12);
	hs.add(3);
	hs.add(85);
	System.out.println(hs);
	hs.remove(3);
	System.out.println(hs);
	hs.add(32);
	System.out.println(hs);
	hs.add(null);
	System.out.println(hs);
}
}
