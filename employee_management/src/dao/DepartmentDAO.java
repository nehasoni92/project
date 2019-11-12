package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Department;


public class DepartmentDAO {

	public List<Department> list() throws SQLException {

		List<Department> listDepartment = new ArrayList<>();
		String url="jdbc:mysql://localhost:3306/employee_management";
		try (Connection connection = DriverManager.getConnection(url, "root", "root")) {
			String sql = "SELECT * FROM dept_list ORDER BY dept_name";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				int dept_id = result.getInt("dept_id");
				String dept_name = result.getString("dept_name");
				Department category = new Department();
				category.setDept_id(dept_id);
				category.setDept(dept_name);
				listDepartment.add(category);
				}} catch (SQLException ex) {
				ex.printStackTrace();
				throw ex;
			}
		return listDepartment;
		}

}

 
