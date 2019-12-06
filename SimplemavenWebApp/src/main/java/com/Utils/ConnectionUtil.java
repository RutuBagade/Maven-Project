package com.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
	public static Connection getconnection() throws IOException 
	{ 
		FileInputStream fis=new FileInputStream("config.properties");
		Properties properties=new Properties();
		properties.load(fis);
		String DBUSER=properties.getProperty("dbusername");
		System.out.println(DBUSER);
		String DBPASS=properties.getProperty("dbpassword");
		System.out.println(DBPASS);
		
		Connection con=null;
	try
	{
		//1.Load Drivers
			Class.forName("com.mysql.jdbc.Driver");
			//2.Create Connection object
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/southwind",DBUSER,DBPASS);	
			System.out.println(DBUSER+" "+DBPASS);
			System.out.println("Connection successful--Connected to DB");
		}
		catch(Exception e) {
			System.out.println("Connection failed");
		}
		return con;
	}
	public static void main(String[] args) throws IOException
	{
		ConnectionUtil.getconnection();
	}

	}


