package com.valuemomentum.training.jdbc_demo;
import java.sql.*;
public class CallableDemo {
	Connection con;
	CallableStatement cstmt;
	ResultSet rs;
	CallableDemo()
	{
		
	}
	void createConnection()
	{
		try {
			// register jdbc driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // creating connection object
            System.out.println("Connection to database");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysqljdbc","root","kawasaki1997");
            
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void getSkills(int candidateId) {
		try {
			String query = "{ call get_candidate_skill(?)}";
			cstmt=con.prepareCall(query);
			cstmt.setInt(1, candidateId);
			
			rs=cstmt.executeQuery();
			while(rs.next()) {
				System.out.println(String.format("%s - %s", rs.getString("first_name")+" "+rs.getString("last_name"),rs.getString("skill")));
			}
		}catch(Exception ce) {
			System.out.println(ce);
		}
	}

	public static void main(String[] args) {
		CallableDemo cd1=new CallableDemo();
		cd1.createConnection();
		cd1.getSkills(133);

	}

}
