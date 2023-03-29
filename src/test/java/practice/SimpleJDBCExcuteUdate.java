package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SimpleJDBCExcuteUdate {


	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			
	Driver drivrRef=new Driver();
		
	DriverManager.registerDriver(drivrRef);
		
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/naveen", "root", "root");
	
	Statement state=con.createStatement();
	
	String query="insert into candidateinfo values('prathop','4','kornul');";
	int result=state.executeUpdate(query);
	if(result==1) {
		System.out.println("db added");
	}
	ResultSet resul=state.executeQuery("select * from candidateinfo;");
	while(resul.next()) {
		System.out.println(resul.getString(1)+" "+resul.getString(2)+" "+resul.getString(3));
	 }
		}
		catch (Exception e) {
			
		}
		finally {
			con.close();
			System.out.println("db close");
			
		}

	}

	}

