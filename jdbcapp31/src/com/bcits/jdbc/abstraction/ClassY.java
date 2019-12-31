package com.bcits.jdbc.abstraction;

public class ClassY implements Connection{

	@Override
	public Statement1 createStatement() {
		
		return new ClassB();
	}

}
