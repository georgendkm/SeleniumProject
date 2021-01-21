package myexercise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/* 1. create connection
 * 2. create statement-query
 * 3. execute statment
 * 4. close connection
 * 
 */

public class JDBCExample1 {

	public static void main(String[] args) throws SQLException {
		//step1. connection
		
		Connection con= DriverManager.getConnection("Connection details: database connection details"); // connection string
		
		//step 2 statement = query
		
		Statement stmt= con.createStatement();
		
		// step3 execute query
		//
		
		String s= "insert into users values(102, 'mercury2, 'mercury2')"; // this is the query for inserting 3 values in a rowquer
		
		String s1= "update users set "uname='mer2' where userid=102"; //updating the username to mer2
		
		
		stmt.executeQuery(s); //executing the query
		
		//ste 4 close the connection
		
		con.close();
		System.out.println("program is executed");
		
		
	}

}
