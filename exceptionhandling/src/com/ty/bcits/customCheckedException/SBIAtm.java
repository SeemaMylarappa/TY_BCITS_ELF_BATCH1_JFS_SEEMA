package com.ty.bcits.customCheckedException;

public class SBIAtm {
public static void main(String[] args)  {
	ATMSimulator a1=new ATMSimulator();
	try {
	a1.withdraw(40000);
	}catch(InsufficientBalance a) {
		System.out.println(a.getMessage());
	}
}
}
