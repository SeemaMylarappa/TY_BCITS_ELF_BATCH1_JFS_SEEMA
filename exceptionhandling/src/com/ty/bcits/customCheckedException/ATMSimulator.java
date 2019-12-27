package com.ty.bcits.customCheckedException;

public class ATMSimulator {
	  int balance=30000;
  void withdraw(int amount) throws InsufficientBalance {
	
	if(amount<=balance) {
		  System.out.println("withdraw successfull");
	  }else {
		  throw new  InsufficientBalance();
	  }
  }
}
