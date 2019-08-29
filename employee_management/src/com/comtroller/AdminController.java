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

import com.model.Admin;

import dao.AdminDAO;
import exception.BusinessException;


@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin=new Admin();
		AdminDAO ad=new AdminDAO();
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		admin.setRules(request.getParameter("rules"));
		admin.setHod(request.getParameter("hod"));
				AdminDAO bo=new AdminDAO();
		RequestDispatcher rd=null;

		try {
			if(ad.SubmitAdminRules(admin))
			{	System.out.println("printed");
				out.println("Submitted Successfully");
				rd=request.getRequestDispatcher("admin.html");
				rd.include(request, response);		
			}
			else
			{
				System.out.println("not printed");
			}
		} catch (ClassNotFoundException | com.exception.BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
