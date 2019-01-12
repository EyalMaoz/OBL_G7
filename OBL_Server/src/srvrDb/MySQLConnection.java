package srvrDb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entities.User;


public class MySQLConnection
{
	private Connection conn;
	public boolean IsConnectionSucceeded = false;
	
	MySQLConnection(String dbName, String dbPassword,String userName) throws SQLException
	{
		try 
		{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} 
		catch (Exception ex) {/* handle the error*/}
	    conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,userName,dbPassword);
	    IsConnectionSucceeded = true;
/*
		try 
		{
		    //Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.3.68/test","root","Root");
		    System.out.println("SQL connection succeed");

		} 
		catch (SQLException ex) 
		{
		    	IsConnectionSucceeded = false;
		    	System.out.println("SQLException: " + ex.getMessage());
		    	System.out.println("SQLState: " + ex.getSQLState());
		    	System.out.println("VendorError: " + ex.getErrorCode());
		}*/
	}
	public ResultSet executeOBLQuery(String query) 
	{
		try 
		{	
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(query);
	 		return rs;			
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
			return null;
		}
	}
	public ResultSet CheckIfUserExist(User userToCheck) 
	{
		try 
		{	
			Statement query = conn.createStatement();
			String queryMsg = "SELECT * FROM obl_db.users WHERE userName ='"+userToCheck.getUserName()
			+"' AND password ='"+userToCheck.getPassWord() +"'";
			ResultSet rs = query.executeQuery(queryMsg);//"SELECT * FROM Students;");
	 		return rs;			
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	public ResultSet SelectAllFrom(String msg) 
	{
		try 
		{	
			Statement query = conn.createStatement();
			ResultSet rs = query.executeQuery(msg);//"SELECT * FROM Students;");
	 		return rs;			
		} 
		catch (SQLException e) 
		{	
			e.printStackTrace();
			return null;
		}
	}
	
	public int updateStudent(String msg)
	{
		try
		{
			Statement stmt = conn.createStatement();
			return stmt.executeUpdate(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	public int executeUpdate(String msg)
	{
		try
		{
			Statement stmt = conn.createStatement();
			return stmt.executeUpdate(msg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	/*public static void printCourses(Connection con)
	{
		Statement stmt;
		try 
		{
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM courses;");
	 		while(rs.next())
	 		{
				 // Print out the values
				 System.out.println(rs.getString(1)+"  " +rs.getString(2));
			} 
			rs.close();
			//stmt.executeUpdate("UPDATE course SET semestr=\"W08\" WHERE num=61309");
		} catch (SQLException e) {e.printStackTrace();}
	}

	
	public static void createTableCourses(Connection con1)
	{
		Statement stmt;
		try {
			stmt = con1.createStatement();
			stmt.executeUpdate("create table courses(num int, name VARCHAR(40), semestr VARCHAR(10));");
			stmt.executeUpdate("load data local infile \"courses.txt\" into table courses");
	 		
		} catch (SQLException e) {	e.printStackTrace();}
		 		
	}*/	
	
}


