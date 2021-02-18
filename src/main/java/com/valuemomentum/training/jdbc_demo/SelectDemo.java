package com.valuemomentum.training.jdbc_demo;

import java.sql.*;
public class SelectDemo {
	 public static void main( String[] args )
	    {
		 Connection con;
			Statement stmt;
			ResultSet rs;
			
			try {
				//Register JDBC driver
				//Class.forName("com.mysql.cj.jdbc.Driver");
				
				// open a connection
				System.out.println("Connecting to database.....");
				con=DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mysqljdbc","root","kawasaki1997");
				
				stmt=con.createStatement();
				rs=stmt.executeQuery("select * from candidates");
				
				while(rs.next()) {
					System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+
						"   "+rs.getString("dob")+"  "+rs.getString("phone")+ "  "+rs.getString("email"));
				}
				rs.close();
				stmt.close();
				con.close();
				
				
	    }catch(Exception e) {
	    	System.out.println(e);
	    }

}
}