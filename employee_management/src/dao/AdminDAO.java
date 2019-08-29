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

	public boolean SubmitAdminRules(Admin admin) throws BusinessException, ClassNotFoundException
	{
		boolean b = false;
		Connection dbConnection=null;

		try{

			String url="jdbc:mysql:://localhost:3306/employee_management";
			Properties info=new Properties();
			info.put("user", "root");
			info.put("password", "root");
			dbConnection = DriverManager.getConnection(url, info);
			PreparedStatement ps=dbConnection.prepareStatement("insert into admin (rules, hod) values(?,?)");
			ps.setString(1, admin.getRules());
			ps.setString(1, admin.getHod());
			ResultSet resultset=ps.executeQuery();
			
			if(resultset.next())
			{
				b=true;
			}else{
				throw new BusinessException("Invalid Credentails");
			}
		} catch (SQLException e) {
			throw new BusinessException("Internal Error....");
		}
		return b;

		}
	}


