package com.bcits.jdbcApp.common;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FindEmployee {
	public static void main(String[] args) throws SQLException {

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		// Load the Driver
		Driver driverRef;
		try {
			driverRef = new Driver();
			DriverManager.registerDriver(driverRef);

			// Get the DB connection via driver
			String dburl = "jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
			con = DriverManager.getConnection(dburl);

			// issue the sql queries via connection
			String query = "select * from employee_primary_info "
					+ "where EMP_ID=20 ";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			// process the results returned by sql queries
			while (rs.next()) {
				int employee_id = rs.getInt("EMP_ID");
				String employee_name = rs.getString("E_NAME");
				Long mobile_number = rs.getLong("MOBILE_NO");                                     
				String email = rs.getString("OFFICIAL_MAILID");
				Date DOb = rs.getDate("DATE_OF_BIRTH");
				Date date_of_joining = rs.getDate("DATE_OF_JOIN");
				String Designation = rs.getString("DESIGNATION");
				String blood_grp = rs.getString("BLOOD_GRP");
				int Salary = rs.getInt("SALARY");
				int Dept_id = rs.getInt("DEPT_ID");
				int manager_id = rs.getInt("MANAGER_ID");

				System.out.println("Employee id=" + employee_id);
				System.out.println("employee_name=" + employee_name);
				System.out.println("mobile number=" + mobile_number);
				System.out.println("official mailid=" + email);
				System.out.println("date of birth=" + DOb);
				System.out.println("date of joining=" + date_of_joining);
				System.out.println("designtion=" + Designation);
				System.out.println("blood group=" + blood_grp);
				System.out.println("salary=" + Salary);
				System.out.println("department id=" + Dept_id);
				System.out.println("manager id=" + manager_id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
