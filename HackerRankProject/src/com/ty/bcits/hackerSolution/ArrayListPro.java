package com.ty.bcits.hackerSolution;
import java.util.ArrayList;
import java.util.Scanner;
public class ArrayListPro 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of lines");
		int n=sc.nextInt();
		ArrayList<ArrayList<Integer>> arraylists=new ArrayList<ArrayList<Integer>>(n);
		ArrayList arraylist=null;
		for (int i = 1; i <=n; i++)
		{
			System.out.println("Enter the number of digits");
			int d=sc.nextInt();
			arraylist=new ArrayList<Integer>(d);
			arraylist.add(0, d);
			
			for (int j = 1; j <=d; j++) 
			{
				System.out.println("Enter the value of"+j+"position");
				arraylist.add(j,sc.nextInt());
				
			}
			
			System.out.println(arraylist.toString());
			arraylists.add(arraylist);
			
		}
		System.out.println(arraylists.toString());
		
		
			System.out.println("Enter the number of queries");
			int q=sc.nextInt();
			for (int i = 0; i <= q; i++) 
			{
				System.out.println("Enter the number of line");	
				int x=sc.nextInt();
				System.out.println("Enter the number of position");
				int y=sc.nextInt();
				System.out.println(arraylists.get(x-1).get(y-1));
			}
			
		}
		
	}

