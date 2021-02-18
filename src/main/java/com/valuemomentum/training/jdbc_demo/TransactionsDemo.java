package com.valuemomentum.training.jdbc_demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionsDemo {

 public static void main(String[] args) throws Exception{
Connection con;
Statement stmt;

 Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc", "root", "kawasaki1997");
stmt = con.createStatement();
con.setAutoCommit(false);
try {
int i1=stmt.executeUpdate("insert into candidate_skills values(101,4) ");
int i2=stmt.executeUpdate("update skills set name='Ruby' where id=1");
int i3=stmt.executeUpdate("delete from candidates where id=34");
con.commit();
System.out.println("Transaction is success");
}catch(Exception e) {
try {
con.rollback();
System.out.println("Transaction is failed");
System.out.println(e.getMessage());
}catch(Exception e1) {
System.out.println(e1.getMessage());
}
}
}

}
