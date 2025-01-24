package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		Connection con = null;
		
		PreparedStatement ps_sin=null,ps_marksIns=null,ps_selS=null,ps_Sins=null;
		ResultSet rs = null;
		
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		String name,email;
		String strDate;
		
		int marks;
		String std;
			
		
		try
		{
			con=JDBCHelper.getConnection();
			System.out.println("Connection estd :" + con);
			
			name=sc2.nextLine();
			System.out.println("Enter the name of student : " + name);
			
			email = sc2.nextLine();
			System.out.println("Enter email of student");
			
			strDate= sc2.nextLine();
			
			ps_Sins = con.prepareStatement("");
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCHelper.close(rs);
			JDBCHelper.close(ps_marksIns);
			JDBCHelper.close(ps_selS);
			JDBCHelper.close(ps_Sins);
			JDBCHelper.close(con);
		}
		
	}

}
