package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.model.User;

 
import exception.BusinessException;


public class LoginDAO {

	public boolean isValidUser(User user) throws BusinessException, ClassNotFoundException, SQLException
	{  System.err.println("isValidUser func called");
		boolean b=false;
		   Connection dbConnection = null;

		    try {
		      String url = "jdbc:mysql://localhost:3306/employee_management";
		      Properties info = new Properties();
		      info.put("user", "root");
		      info.put("password", "root");

		      dbConnection = DriverManager.getConnection(url, info);
		      
		      Statement stmt = dbConnection.createStatement();

		      String sql = "SELECT user_id,password FROM login_master where user_id = "+user.getUser_id()+" and password ="+user.getPassword()+ "  ";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		    	  b = true; 
		         int id  = rs.getInt("user_id");
		         String pass  = rs.getString("password");

		         System.out.print("ID: " + id); 
		         System.out.print("pass: " + pass); 
		        
		         
		      }
		      rs.close();

		      if (dbConnection != null) {
		        System.out.println("Successfully connected to MySQL database test");
		      dbConnection.close();
		      
		      }

		    } catch (SQLException ex) {
		      System.out.println("An error occurred while connecting MySQL databse");
		      ex.printStackTrace();
		    }
	System.err.println("b" +b);
		return b;
	}

		
}
