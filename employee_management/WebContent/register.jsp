<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.model.Department"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div align="center">
		<h1 style="text-decoration: underline">Registration</h1>
		<form action="" method="post">
			<table border="1px">


				<tr>
					<td>Name: <input type="text" name="username"></td>
				</tr>
				<br />
				<br />


				<tr>
					<td>Email: <input type="email" name="email"></td>
				</tr>
				<br />
				<br />

				<tr>
					<td>Mobile No. <input type="number" name="number"></td>
				</tr>
				<br />
				<br />

				<tr>
					<td>Designation <select name="category">
							<%
								ArrayList users = (ArrayList) request.getAttribute("listCategory");
								for (int i = 0; i < users.size(); i++) {
									Department user = (Department) users.get(i);
							%>

							<option value="<%out.print(user.getDept_id());%>">
								<%
									out.print(user.getDept());
								%>
							</option>

							<%
								}
							%>
					</select></td>
				</tr>
				<br />



				<br />


				<tr>
					<td>Submit: <input type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>