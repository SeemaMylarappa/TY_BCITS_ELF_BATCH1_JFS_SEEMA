package com.ty.bcits.customCheckedException;

public class InsufficientBalance extends Exception{
 String msg="insufficient balance";

public InsufficientBalance() {
	super();
}

public InsufficientBalance(String msg) {
	
	this.msg = msg;
}
 @Override
	public String getMessage() {
		return this.msg;
	}
}
