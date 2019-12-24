package com.ty.bcits.hackerSolution;
import java.util.HashSet;
import java.util.Scanner;
public class HashSetSolution 
{
public static void main(String[] args) 
{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the number of pairs");
	int t=Integer.parseInt(sc.nextLine());
	HashSet<String> hs=new HashSet<String>();
	
	
	
	for (int i = 0; i <=t; i++)
	{
		System.out.println("Enter the fist name");
		String x=sc.nextLine();
		System.out.println("Enter the second name");
		String y=sc.nextLine();
		hs.add(x+" "+y);
		System.out.println(hs.size());
	}
	
}
}
