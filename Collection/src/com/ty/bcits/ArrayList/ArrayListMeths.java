package com.ty.bcits.ArrayList;

import java.awt.List;
import java.util.ArrayList;

public class ArrayListMeths 
{
	public static void main(String[] args) {
		ArrayList<Integer> al=new ArrayList<Integer>();
		  al.add(32);
		  al.add(47);
		  al.add(32);
		  System.out.println(al);
		  al.add(1, 82);
		  System.out.println(al);
		  al.remove(1);
		  al.remove(new Integer(82));
		  System.out.println(al);
		  al.set(0, 33);
		  System.out.println(al);
		 System.out.println(al.indexOf(32));
		 System.out.println(al.lastIndexOf(32));
		 System.out.println("==============");
		 
		 
			 java.util.List<Integer> a=al.subList(0, 1);
			 System.out.println(a);
		
		
		 System.out.println(al);
		 for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		  
		  
	}
  
  
  
}
