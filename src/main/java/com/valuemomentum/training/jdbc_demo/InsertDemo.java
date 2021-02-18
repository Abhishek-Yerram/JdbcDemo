package com.valuemomentum.training.jdbc_demo;
import java.sql.*;
public class InsertDemo {

	public static void main(String[] args) {
		Connection con;
        Statement stmt;
        ResultSet rs;
        int cnt=0;
        try {
            // register jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creating connection object
            System.out.println("Connection to database");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","kawasaki1997");
            // execute a query
            
            String str="INSERT INTO skills(name)"+"VALUES('Spring Boot')";
            stmt=con.createStatement();
            int rowcount=stmt.executeUpdate(str);
            if(rowcount>0) {
                System.out.println("RECORD INSERETED SUCCESSFULLY");
            }
            String st1="select count(id) from skills";
            rs=stmt.executeQuery(st1);
            while(rs.next()) {
                cnt=rs.getInt(1);
                System.out.println("TOTAL NUMBER OF RECORDS IS: "+cnt);
                con.close();
                stmt.close();
                rs.close();
            }

 

    }
        catch(Exception e) {
            System.out.println(e);
        }

	}

}
