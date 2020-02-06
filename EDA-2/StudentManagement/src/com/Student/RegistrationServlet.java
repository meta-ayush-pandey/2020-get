package com.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("fname");
		String last_name = request.getParameter("lname");
		String email = request.getParameter("email");
		String father_name = request.getParameter("father_name");
		String age = request.getParameter("age");
		String standard = request.getParameter("class");
		Statement stmt = DatabaseConnection.createConnection("StudentRegistration", "root", "root");
		String query = String.format("Insert into Student(name,last_name,father_name,email,standard,age) values('%s','%s','%s','%s','%s','%s')",name,last_name,father_name,email,standard,age);
		try {
			stmt.executeUpdate(query);
			System.out.println("sucessfully inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><p><b>sucessfully registered</b></p><br><a href=Index.html>Home</a></body></html>");
		
		
		
		
	}

}
