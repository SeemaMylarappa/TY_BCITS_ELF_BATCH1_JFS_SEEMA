package com.ty.bcits.TreeMap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapSol {
public static void main(String[] args) {
	TreeMap<Integer,String> t1=new TreeMap<Integer,String>();
	t1.put(23, "Seema");
	t1.put(24, "Sahana");
	t1.put(21, "Vinay");
	t1.put(25, "Venkatesh");
	 Set<Map.Entry<Integer,String>> s1=t1.entrySet();
	 for (Entry<Integer, String> entry : s1) {
		System.out.println(entry.getValue());
		System.out.println(entry.getKey());
	}
	 
}
}
