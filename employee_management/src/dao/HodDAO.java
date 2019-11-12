package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.model.HOD;

public class HodDAO {

	public boolean hodConnection()
	{
		boolean b=false;
		Connection dbConnection=null;
		HOD hod=new HOD();

		try{

			String url= "jdbc:mysql://localhost:3306/employee_management";
			Properties info=new Properties();
			info.put("user", "root");
			info.put("pass", "root");
			dbConnection=DriverManager.getConnection(url, info);
			Statement stmt = dbConnection.createStatement();
			String sql="select rules.message, emp_dept.dept_name from rules inner join emp_dept on rules.dept_id=emp_dept.department_id where emp_dept.dept_name="+hod.getDept()+" and rules.message="+hod.getMessage()+" ";
			ResultSet rs =stmt.executeQuery(sql);
			if(rs.next())
			{
				b=true;
				String message=rs.getString("rules.message");
				String dept_name=rs.getString("emp_dept.dept_name");

			}
			rs.close();
			if (dbConnection != null) {
				System.out.println("Successfully connected to MySQL database test");
				dbConnection.close();

			}
		}
		
		catch (SQLException ex) {
		      
		      ex.getMessage();
		    }
		return b;
	}


}
