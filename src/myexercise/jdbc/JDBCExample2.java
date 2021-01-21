
package myexercise.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/* 1. create connection
 * 2. creaate statement
 * 3. execute statment
 * 4. close connection
 * 
 */


	
public class JDBCExample2 {

	public static void main(String[] args) throws SQLException {
		//step1. connection
		
		Connection con= DriverManager.getConnection("Connection details: database connection details"); // connection string
		
		//step 2 statement = query
		
		Statement stmt= con.createStatement();
		
		// step3 execute query
		//
		String s= "select uname, passwrd from users";// selecting data
		
		//step 4
		ResultSet rs= stmt.executeQuery(s);//keep the selected itesm in resultset class
		
		While(rs.next()){
			String username= rs.getString("uname");
			String password =rs.getString("passwrd");
			System.out.print(username+"  ");
			System.out.println(password);
		}
		
		
		
		stmt.executeQuery(s); //executing the query
		
		//ste 4 close the connection
		
		con.close();
		System.out.println("program is executed");
		
}
