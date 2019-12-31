package com.bcits.jdbcApp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MyThirdJDBCProgram {

	Connection con = null;
	Statement st = null;
	int rs = 0;

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dbUrl = "jdbc:mysql://localhost:3306/employee_management_info?";

			Connection con = DriverManager.getConnection(dbUrl, "root", "root");

			String query = " update employee_primary_info set e_name='gagana' where emp_id=10 ";
			Statement st = con.createStatement();
			int rs = st.executeUpdate(query);

			System.out.println("number of rows affected:" + rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end of main
}// end of class
