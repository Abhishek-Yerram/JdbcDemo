package com.valuemomentum.training.jdbc_demo;

import java.sql.*;


public class MysqlConn {
	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		ResultSet rs;
		
		try {
			//Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// open a connection
			System.out.println("Connecting to database.....");
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/classicmodels","root","kawasaki1997");
			
			// execute a query
			stmt=con.createStatement();
			rs=stmt.executeQuery("select employeeNumber,firstName,jobTitle from employees");
			
			//Extract data from result set
			/*while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3)+
					"   "+rs.getString(4)+"  "+rs.getString("email")+ "  "+rs.getString(6)+
					"   "+rs.getInt(7)+"   "+rs.getString(8));*/
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getString(3));
				
			}
			rs.close();
			stmt.close();
			con.close();
			
				
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	

}
