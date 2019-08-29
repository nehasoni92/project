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

import com.bo.LoginBO;
import com.model.User;

import dao.LoginDAO;
import exception.BusinessException;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		user.setUser_id(Integer.parseInt(request.getParameter("userid")));
		user.setPassword(request.getParameter("password"));
		user.setRole(request.getParameter("role"));
		//LoginBO bo=new LoginBO();
		LoginDAO bo = new LoginDAO();
		RequestDispatcher rd=null;
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		try{
			try {
					if(bo.isValidUser(user) && user.getRole().equalsIgnoreCase("admin"))
				{ 
					
				rd=request.getRequestDispatcher("admin.html");
				rd.forward(request, response);		
				
				}
				
				else
				{ System.out.println("password incorrect");
				request.setAttribute("msg", "password incorrect, please login again");

				rd=request.getRequestDispatcher("login.jsp");

				rd.forward(request, response);

				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}catch(BusinessException e)
		{ 
			/*rd=request.getRequestDispatcher("login.html");
		rd.include(request, response);*/
			System.out.println(e.getMessage());
			//out.print("<center><span style='color:red;'>"+e.getMessage()+"</span></center>");
		}
	}

}
