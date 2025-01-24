package com.jdbc;

import java.sql.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String Driver = "com.mysql.cj.jdbc.Driver";
		
		String URL = "jdbc:mysql://localhost:3306/new_schema";
		String UID = "root";
		String pass = "root";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try
		{
			Class.forName(Driver);
			con = DriverManager.getConnection(URL,UID,pass);
			System.out.println("connection estd");			
			
			// Create an SQL UPDATE statement
		    String sql = "UPDATE student SET email = ? WHERE sl_no = ?";
		    
		    // Prepare the statement
		    ps = con.prepareStatement(sql);
		    
		    // Set the parameters
		    ps.setString(1, "newemail@example.com"); // New email value
		    ps.setInt(2, 1); // Specify the sl_no to update (e.g., 1)
		    
		    // Execute the update
		    int rowsAffected = ps.executeUpdate();
		    
		    System.out.println(rowsAffected + " row(s) updated.");
		    
		    ps = con.prepareStatement("select * from student");
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int sl = rs.getInt("sl_no");
				String name = rs.getString("name");
				String dob = rs.getString("dob");
				String email = rs.getString("email");
				
				System.out.println(sl + dob + name + email);
			}
		
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				ps.close();
				rs.close();
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		
	}

}
