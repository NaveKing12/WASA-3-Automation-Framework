package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SimpleJDBCExcuteQuery {

	public static void main(String[] args) throws SQLException {

		//Driver for mysql Database.
         Driver driverRef=new Driver();
		
		//Step 1: Register the Driver.
		DriverManager.registerDriver(driverRef);
		
		//Step 2: Get connection from Database-database name.
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/naveen", "root", "root");
		
		//Step 3: issue the create statement.
		Statement state= con.createStatement();
		
		//Step 4: execute the Query-table name.
		ResultSet result= state.executeQuery("select * from candidateinfo;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2) +result.getString(3));
		}
		
		//Close the Database.
		con.close();
		System.out.println("db Closed.");
	}

}
