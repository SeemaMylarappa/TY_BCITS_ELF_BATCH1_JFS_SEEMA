package com.bcits.jdbcApp.common;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Driver;
public class MyFirstjdbcProgram2 {

	public static void main(String[] args) {

			Connection con = null;
			ResultSet rs = null;
			Statement stmt = null;
			try {
				
				
				// 1.Load the "Driver"
				/*Driver driverRef = new Driver();
				DriverManager.registerDriver(driverRef);*/
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
				// 2.Get the DB connection via Driver
	           
				String dbUrl = "jdbc:mysql://localhost:3306/employee_management_info";
				FileInputStream file=new FileInputStream("dbInfo properties");
				Properties prop=new Properties();
				prop.load(file);
				
				con = DriverManager.getConnection(dbUrl,"root","root");//overloading of getConnection()

				// 3.Issue sql queries
				String query = "select * from employee_primary_info";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
	  
				// 4.Process the results
				while (rs.next()) {
					int employeeID = rs.getInt("EMP_ID");
					String employeeNM = rs.getString("E_NAME");
					double employeeSalary = rs.getDouble("SALARY");
					int departmentID = rs.getInt("DEPT_ID");
					Date joining_date = rs.getDate("DATE_OF_JOIN");
					long mobileNumber = rs.getLong("MOBILE_NO");
					String email = rs.getString("OFFICIAL_MAILID");
					String designation = rs.getString("DESIGNATION");
					Date dob = rs.getDate("DATE_OF_BIRTH");
					int managerId = rs.getInt("MANAGER_ID");

					System.out.println("Employee ID===>" + employeeID);
					System.out.println("Employee name==>" + employeeNM);
					System.out.println("Employee salary==>" + employeeSalary);
					System.out.println("Department ID====>" + departmentID);
					System.out.println("joining date===>" + joining_date);
					System.out.println("Mobile Number===>" + mobileNumber);
					System.out.println("Email ID===>" + email);
					System.out.println("Designation:" + designation);
					System.out.println("Date of birth===>" + dob);
					System.out.println("Manager ID===>" + managerId);
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				// 5.close all jdbc objects
				try {
					if (con != null) {
						con.close();
					}
					if (rs != null) {
						rs.close();
					}
					if (stmt != null) {
						stmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

		}
	}


