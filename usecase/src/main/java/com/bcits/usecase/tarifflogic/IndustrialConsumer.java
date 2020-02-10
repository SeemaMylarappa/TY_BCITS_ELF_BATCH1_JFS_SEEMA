package com.bcits.usecase.tarifflogic;

import java.util.Scanner;

public class IndustrialConsumer {
	
public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of units");
		double units=sc.nextDouble();
		double cost=0;
		
		if(units<=10000) {
			cost=units*15;
			
		}
			else if(units>10000 && units<=20000) {
				cost=cost+(units-10000)*20;
				
			}
				else{
					cost=cost+(units-20000)*25;
					
				}
	    System.out.println("The cost is:"+cost);
			}
		


}
