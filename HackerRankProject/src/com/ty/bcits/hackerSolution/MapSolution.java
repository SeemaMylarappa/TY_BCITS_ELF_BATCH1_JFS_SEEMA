package com.ty.bcits.hackerSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapSolution {
	public static void main(String[] args) {
		System.out.println("Enter the number of entries in the phonebook");
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Map<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 1; i <=n; i++)
		{
			System.out.println("Enter the name");
			String st=sc.nextLine();
			System.out.println("Enter the phone number");
			int x=Integer.parseInt(sc.nextLine());
			map.put(x, st);
		}
		System.out.println(map);
		System.out.println("enter the number of queries");
		int q=Integer.parseInt(sc.nextLine());
		for (int i = 1; i <=q; i++) {
			System.out.println("Enter name for searching");
			String name=sc.nextLine();
			
			System.out.println("Enter number for searching");
			Integer number=Integer.parseInt(sc.nextLine());
			
		
			if(map.get(number)!=null)
			{
				System.out.println(name+" "+number);
			}
			else
			{
				System.out.println("not present");
			}
			
		}

	}
}
