package com.ty.bcits.CollectionPractice;

import java.util.ArrayList;
import java.util.Collection;

public class ColectionMeths
{
public static void main(String[] args) 
{
	Collection<Integer> c1=new ArrayList<Integer>();
	c1.add(12);
	c1.add(45);
	
	Collection<Integer> c2=new ArrayList<Integer>();
	c2.add(1);
	c2.add(45);
	c2.add(89);
	System.out.println(c1);
	System.out.println(c2);
	c2.addAll(c1);
	System.out.println("---------------------");
	System.out.println(c1);
	System.out.println(c2);
	c2.removeAll(c1);
	System.out.println("---------------------");
	System.out.println(c1);
	System.out.println(c2);                                                                                                            
	
	
	Collection<Integer> c3=new ArrayList<Integer>();
	c3.add(44);
	c3.add(57);
	Collection<Integer> c4=new ArrayList<Integer>();
	c4.add(44);
	c4.add(58);
	c4.add(78);
	System.out.println(c4.contains(c3));
	System.out.println(c4.containsAll(c3));
	
	System.out.println("--------------------------");
	System.out.println(c3);
	System.out.println(c4);
	c4.retainAll(c3);
	System.out.println(c3);
	System.out.println(c4);
	System.out.println("----------------------------");
	Object[] o1=c4.toArray();
   for (int i = 0; i < o1.length; i++) 
   {
	System.out.println(o1[i]);
}
  
   
	
}
}
