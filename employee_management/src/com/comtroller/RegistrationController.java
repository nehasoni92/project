package com.comtroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;

import dao.RegistrationDAO;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/registration")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();		
		Employee emp=new Employee();
		RequestDispatcher rd=null;
		RegistrationDAO rg=new RegistrationDAO();
		emp.setName(request.getParameter("username"));
		emp.setEmail(request.getParameter("email"));
		emp.setMobile(request.getParameter("number"));
		emp.setDesignation("category");
		try{

			if(rg.SubmitEmployee(emp))
			{
				out.println("Registered Successfully..");

				rd=request.getRequestDispatcher("registration");
				rd.include(request, response);					
			}else
			{
				out.println("Please enter valid details..");
			}}
		catch (SQLException | ClassNotFoundException | com.exception.BusinessException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}



	}

}
