package com.ty.bcits.customUncheckedException;

public class AgeLimitException extends RuntimeException{
 String msg="Age is less than 18";
 public AgeLimitException() {
	 
 }

public AgeLimitException(String msg) {
	
	this.msg = msg;
}
@Override
	public String getMessage() {
		
		return this.msg;
	}
 
}
