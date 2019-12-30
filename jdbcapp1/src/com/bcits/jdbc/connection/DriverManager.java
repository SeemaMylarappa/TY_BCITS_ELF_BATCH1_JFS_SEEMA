package com.bcits.jdbc.connection;

public class DriverManager {
  private DriverManager() {
}
	public static Connection getConnection(String dbUrl) {
		//some business logic
		Connection ref=null;
		if(dbUrl.equals("one")){
			ref=new ClassA();
		}else {
			ref=new ClassB();
		}
		return ref;
	}//end of myMethod
}//end of the class
