package com.valuemomentum.training.jdbc_demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import java.util.Scanner;

public class UpdateDemo {

	private static String sqlUpdate;

	public static void main(String[] args) {
		Connection con;
        Statement stmt;
        ResultSet rs;
        PreparedStatement pstmt;
        String sqlUpdate;
        int cnt=0;
        try {
            // register jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creating connection object
            System.out.println("Connection to database");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","kawasaki1997");
            // execute a query
            
            sqlUpdate="Update candidates Set last_name = ? where id = ?";
            pstmt=con.prepareStatement(sqlUpdate);
            
            // prepare data for update
            Scanner s=new Scanner(System.in);
            System.out.println("enter Employee id: ");
            int eid=s.nextInt();
            System.out.println("enter Employee's new new last_name: ");
            String lastname=s.next();
            
            pstmt.setString(1,lastname);
            pstmt.setInt(2,eid);
            
            int rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            
            //reuse the prepared statement
            lastname="Grohe";
            eid=101;
            pstmt.setString(1,lastname);
            pstmt.setInt(2,eid);
            
            rowAffected = pstmt.executeUpdate();
            System.out.println(String.format("Row affected %d", rowAffected));
            con.close();
        }
        catch(Exception ce) {
        	System.out.println(ce);
        }


	}

}
