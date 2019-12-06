package com.Test;
import com.Utils.*;
import java.sql.*;

import com.Utils.ConnectionUtil;
import com.Utils.EmailUtil;
public class Mysqlcon
{
public static void main(String args[])throws Exception
{
	
	Connection con=ConnectionUtil.getconnection();

		Statement stmt=con.createStatement();

		ResultSet rs=stmt.executeQuery("select * from emp");

		while(rs.next())
		{
		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4));
		EmailUtil.send(rs.getString(4),"Future Developers","Welcome to Advance java Class" );
		}
		
		/*ResultSet rs1=stmt.executeQuery("select * from student");
			while(rs1.next())
			{
			System.out.println(rs1.getInt(1)+"  "+rs1.getString(2)+"  "+rs1.getFloat(3));
			
			}*/
       con.close();
	}
	
}



