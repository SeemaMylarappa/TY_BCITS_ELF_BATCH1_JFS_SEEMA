package com.bcits.usecase.tarifflogic;

import java.util.Scanner;

public class ResidentialConsumer {
	
	public static void main(String[] args) {
		
		
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter number of units");
			double units=sc.nextDouble();
			double cost=0;
			
			if(units<=100) {
				cost=units*4;
				
			}
				else if(units>100 && units<=200) {
					cost=cost+(units-100)*5;
					
				}
					else{
						cost=cost+(units-200)*8;
						
					}
		    System.out.println("The cost is:"+cost);
				}
		
		
	}
	


