package com.bcits.jdbcApp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class MySecondJDBCprogram {

	  Connection con=null;
	   Statement stmt=null;
	   int rs=0;
	public static void main(String[] args) {
		
		//load the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//get the database connection via driver
			String dbURl="jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
			Connection con=DriverManager.getConnection(dbURl);
			
			//issue sql queries
			String query="insert into employee_primary_info values(116,'manasa',"
					+ " 9852300047,'manasa12@gmail.com', "
					+ " '1997-10-15','2019-10-25','tester','ab+',43000,20,118) ";
			 Statement stmt=con.createStatement();
			 int rs=stmt.executeUpdate(query);
			
			
			//process the results
			System.out.println("Number of rows affected:"+rs);
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}//end of main
}//end of class
