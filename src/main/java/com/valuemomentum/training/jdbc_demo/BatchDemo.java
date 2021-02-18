package com.valuemomentum.training.jdbc_demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

 

public class BatchDemo {

 

    public static void main(String[] args) {
        Connection con;
        Statement stmt;
        ResultSet rs;
        try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         // creating connection object
         System.out.println("Connection to database");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","kawasaki1997");
         stmt=con.createStatement();
         stmt.addBatch("insert into candidate_skills values(100,5)");
         stmt.addBatch("update skills set name='Ajax' where id=3");
         stmt.addBatch("Delete from candidates where id=80");
         
         con.setAutoCommit(false);
         try {
             stmt.executeBatch();
             con.commit();
             System.out.println("batch created successfully");
         }
         catch(Exception e) {
             try {
                 con.rollback();
                 System.out.println("batch is failed");
                 System.out.println("exception is"+e);
             }
             catch(Exception e1) {
                 System.out.println(e1);
             }
         }
stmt.close();
con.close();

 

    }
        catch(Exception e) {
            System.out.println(e);
        }
        
    }

 

}
