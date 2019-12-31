package com.bcits.jdbc.abstraction;

public class MainMethodProgram {
	
public static void main(String[] args) {
	
	String dbUrl="one";
	Connection con=DriverManager.getConnection(dbUrl);
	Statement1 stmt=con.createStatement();
	stmt.method1();
}//end of main
}//end of class
