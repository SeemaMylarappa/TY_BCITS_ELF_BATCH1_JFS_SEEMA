package com.ty.bcits.propertiesexamp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileReader {

	public static void main(String[] args) {

		try {
			FileInputStream inputStream = new FileInputStream("dbInfo.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			System.out.println("DriverName====" + properties.getProperty("driveNm"));
			System.out.println("Db URL====" + properties.getProperty("dbURL"));
			System.out.println("User=====" + properties.getProperty("user"));
			System.out.println("PAssword====" + properties.getProperty("password"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end of main
}// end of class
