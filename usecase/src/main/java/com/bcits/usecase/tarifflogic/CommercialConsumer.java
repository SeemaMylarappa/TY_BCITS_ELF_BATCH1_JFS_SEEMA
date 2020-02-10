package com.bcits.usecase.tarifflogic;

import java.util.Scanner;

public class CommercialConsumer {
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of units");
		double units=sc.nextDouble();
		double cost=0;
		
		if(units<=1000) {
			cost=units*10;
			
		}
			else if(units>1000 && units<=2000) {
				cost=cost+(units-100)*15;
				
			}
				else{
					cost=cost+(units-2000)*18;
					
				}
	    System.out.println("The cost is:"+cost);
			}

		
		
		
	}
	
	

