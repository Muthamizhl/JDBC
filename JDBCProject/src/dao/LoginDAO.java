package dao;

import java.sql.*;

import connectionManager.ConnectionManager;
import model.Login;

public class LoginDAO 
{
	public boolean validate(Login login) throws ClassNotFoundException, SQLException
	{
		String username = login.getUsername();
		String password = login.getPassword();
		
		ConnectionManager conn=new ConnectionManager();
		Connection con=conn.establishConnection();
		
		//Create a student object to execute query
		Statement st=con.createStatement();
		
		//Execute the statement obj and return a query result
		ResultSet rs=st.executeQuery("select * from login");
		
		while(rs.next())
		{
			if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
			{
				conn.closeConnection();
				return true;
			}
			
		}
		conn.closeConnection();
		return false;
	}
	
}