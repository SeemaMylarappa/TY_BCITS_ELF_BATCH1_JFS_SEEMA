package com.bcits.jdbc.connection;

public class MainMethodClass {

	public static void main(String[] args) {
		
		String dbUrl="one";
		
		Connection con=DriverManager.getConnection(dbUrl);
		con.print();
	}
}
