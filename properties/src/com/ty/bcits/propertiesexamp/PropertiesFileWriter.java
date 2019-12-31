package com.ty.bcits.propertiesexamp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileWriter {
	public static void main(String[] args) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("dbInfo.properties");
			Properties properties = new Properties();
			properties.setProperty("driveNm", "com.mysql.jdbc.Driver");
			properties.setProperty("dbURL", "jdbc:mysql://localhost:3306/employee_management_info");
			properties.setProperty("user", "root");
			properties.setProperty("password", "root");
			try {
				properties.store(fileOutputStream, "Db detail");
				System.out.println("file created");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end of main
}// end of class
