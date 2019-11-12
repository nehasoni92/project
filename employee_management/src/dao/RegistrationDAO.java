package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import com.exception.BusinessException;
import com.model.Admin;
import com.model.Department;
import com.model.Employee;

public class RegistrationDAO {
	
	public boolean SubmitEmployee(Employee employee) throws BusinessException, ClassNotFoundException, SQLException
	{
		boolean b = false;
		Connection dbConnection=null;
		System.out.println(employee);
		try{

			String url="jdbc:mysql://localhost:3306/employee_management";
						
			Properties info=new Properties();
			info.put("user", "root");
			info.put("password", "root");
			dbConnection = DriverManager.getConnection(url, info);
			String sql="insert into employees(email, name, phone_no, designation) values(?,?, ?, ?)";
			PreparedStatement ps=dbConnection.prepareStatement(sql);
		
			ps.setString(1, employee.getEmail());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getMobile());
			ps.setString(4, employee.getDesignation());
			
			int resultset=ps.executeUpdate();

			if(resultset == 1)
			{
				b=true;
			}else{
				throw new BusinessException("Invalid");
			}
		}catch(SQLException e){
			
			e.getMessage();
		}
		return b;
	}
}

	