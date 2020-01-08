package com.bcits.jdbcapp02.practice;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementExample {
     public static void main(String[] args) {
    	 Connection con = null;
 		ResultSet rs = null;
 		PreparedStatement pstmt=null;
    	 try {
		//1]load the driver
    	 Class.forName("com.mysql.jdbc.Driver").newInstance();
    	 
    	 //2]Get the DB connection 
    	 String dbUrl="jdbc:mysql://localhost:3306/employee_management_info";
    	 con=DriverManager.getConnection(dbUrl, "root","root");
    	 
    	 //3]Issue the SQL queries via connection
    	 String query="select * from employee_primary_info "
    			 + "where emp_id=? ";
    	  pstmt=con.prepareStatement(query);
    	 pstmt.setInt(1, Integer.parseInt(args[0]));
    	  rs=pstmt.executeQuery();
    	 
    	// 4.Process the results
    				if (rs.next()) {
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
    	 
    	 }else {
    		 System.err.println("Employee ID Not Found");//err gives red color
    	 }
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
    	 
    	 finally {
 			// 5.close all jdbc objects
 			try {
 				if (con != null) {
 					con.close();
 				}
 				if (rs != null) {
 					rs.close();
 				}
 				if (pstmt != null) {
 					pstmt.close();
 				}
 			}
    	 catch(Exception e) {
    		 e.printStackTrace();
    	 }
 			//end of inner try-catch block
    	 
	}//end of main
     

}
}//end of class
