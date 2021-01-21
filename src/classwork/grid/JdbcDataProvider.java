package classwork.grid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

public class JdbcDataProvider {
	
	private Connection connect=null;
	private Statement statement= null;
	private ResultSet resultSet=null;
			
	@DataProvider(name="jdbcData")
	public Object[][] readDataBase() throws Exception{
		String [][] databaseArray;
		
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			//connection
			connect= DriverManager.getConnection("Jdbc:mysql://localhost/DEMO?user=root&password=1234");
			
			//statement for creating queries
			statement= connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

		
			//creating the resultSet to get the result
			resultSet= statement.executeQuery("select * from demo.search");
		
			//get number of rows and columns
			resultSet.last();
			
			int rows= resultSet.getRow();
			System.out.println("number of rows in this table:"+rows);
		
			int cols= resultSet.getMetaData().getColumnCount();
			System.out.println("number of columns in this table:"+cols);
		
			//declare the size of the 2d array
		
			databaseArray= new String[rows][cols];
			int r =0;
			resultSet.beforeFirst();
			//getting the data from the table using .next from the heading.
			while(resultSet.next()) {
				String items= resultSet.getString("items");
				System.out.println("items in the table:"+ items);
				databaseArray[r][0]= items;
				r++;
			
			} 
		
			

	} catch (Exception e) {
			throw e;
			
		} finally {
			close();
		}
		
		
		return databaseArray;
		
	}


	private void close() {
		// TODO Auto-generated method stub
		
	}
}




/*			//stat=con.prepareStatement("select typeid from users where username=? and password=?",
ResultSet.TYPE_SCROLL_SENSITIVE, 
      ResultSet.CONCUR_UPDATABLE);
*/