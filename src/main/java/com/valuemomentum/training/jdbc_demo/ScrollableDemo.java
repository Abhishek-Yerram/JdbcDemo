package com.valuemomentum.training.jdbc_demo;

import java.sql.*;

public class ScrollableDemo {

	public static void main(String[] args) {
		 Connection con;
         Statement stmt;
         ResultSet rs;
         
         try {
             //Register JDBC driver
            
             
             //Class.forName("com.mysql.cj.jdbc.Driver");
             
             // open a connection
             
             con=DriverManager.getConnection(
                     "jdbc:mysql://localhost:3306/mysqljdbc","root","kawasaki1997");
             
             stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
            		 ResultSet.CONCUR_READ_ONLY);//scrollable result set
             rs=stmt.executeQuery("select * from skills");
             
             // reading from bottom to top
             rs.afterLast();
             while(rs.previous()) {
                 System.out.println(rs.getInt(1)+"   "+rs.getString(2));
                 
             }
             System.out.println("**********************************");
             
             //move cursor to third record
             rs.absolute(3);
             System.out.println(rs.getInt(1)+"   "+rs.getString(2));
             
             System.out.println("**********************************");
             
             //move the cursor to second record 
             rs.relative(-1);
             System.out.println(rs.getInt(1)+"   "+rs.getString(2));
             System.out.println("**********************************");
             
             int i=rs.getRow();// to get current cursor position
             System.out.println("cursor position "+i);
             
             //clean up
             rs.close();
             stmt.close();
             con.close();
 
         }
         catch(Exception e) {
             System.out.println(e);
         }

	}

}
