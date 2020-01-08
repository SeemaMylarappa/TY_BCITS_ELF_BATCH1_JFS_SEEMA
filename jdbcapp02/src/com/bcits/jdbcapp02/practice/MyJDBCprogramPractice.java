package com.bcits.jdbcapp02.practice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

public class MyJDBCprogramPractice {

	Connection con = null;
	Statement st = null;
	int rs = 0;

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			String dbUrl = "jdbc:mysql://localhost:3306/employee_management_info?";
			FileInputStream inputStream = new FileInputStream("dbInfo.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			Connection con = DriverManager.getConnection(dbUrl,properties);

			String query = " delete from employee_primary_info where emp_id=116";
			Statement st = con.createStatement();
			int rs = st.executeUpdate(query);

			System.out.println("number of rows affected:" + rs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end of main
}
