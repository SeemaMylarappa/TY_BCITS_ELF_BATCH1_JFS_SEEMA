package com.bcits.jdbc.abstraction;

public class ClassX implements Connection{

	@Override
	public Statement1 createStatement() {
		
		//return new ClassA()
		return new ClassC();
	}

}
