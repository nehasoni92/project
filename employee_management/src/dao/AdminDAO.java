package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.exception.BusinessException;
import com.model.Admin;

public class AdminDAO {

	public boolean SubmitAdminRules(Admin admin) throws BusinessException, ClassNotFoundException, SQLException
	{
		boolean b = false;
		Connection dbConnection=null;
		System.out.println(admin);
		try{

			String url="jdbc:mysql://localhost:3306/employee_management";
						
			Properties info=new Properties();
			info.put("user", "root");
			info.put("password", "root");
			dbConnection = DriverManager.getConnection(url, info);
			String sql="insert into admin(rules, role) values(?,?)";
			PreparedStatement ps=dbConnection.prepareStatement(sql);
			ps.setString(1, admin.getRules());
			ps.setString(2, admin.getHod());
			
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



