package com.ty.bcits.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapMeth {
public static void main(String[] args) {
	HashMap<Integer,String> h1=new HashMap<Integer, String>();
	h1.put(21, "Seema");
	h1.put(23, "Sahana");
	h1.put(45, "Venkatesh");
	Set<Map.Entry<Integer,String>> s1=h1.entrySet();
	for (Entry<Integer, String> entry : s1) {
		System.out.println(entry.getKey());
		System.out.println(entry.getValue());
		System.out.println("=================");
	}
	System.out.println(h1.get(21));
	
	System.out.println("=========================");
	Set<Integer> s2=h1.keySet();
	for (Integer integer : s2) {
		System.out.println(integer);
	}
	
	System.out.println("================================");
	Collection<String> c1=h1.values();
	for (String string : c1) {
		System.out.println(string);
	}
}
}
