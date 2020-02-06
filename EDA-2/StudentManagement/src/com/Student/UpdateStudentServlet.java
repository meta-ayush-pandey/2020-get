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
 * Servlet implementation class UpdateStudentServlet
 */
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStudentServlet() {
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
		
		int Id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String fatherName = request.getParameter("father_name");
		String email = request.getParameter("email");
		String className = request.getParameter("class");
		String age = request.getParameter("age");
//		System.out.println("name is "+ firstName+ " "+lastName);
//		System.out.println("father is "+ fatherName);
//		System.out.println("email is "+ email);
//		System.out.println("class is "+ className);
//		System.out.println("age is "+ age);
		
		
		Statement stmt = DatabaseConnection.createConnection("StudentRegistration", "root","root");
		String query = String.format("UPDATE student SET name='%s',last_name='%s' , father_name='%s', email='%s',standard='%s',age='%s' WHERE id=%d",firstName,lastName,fatherName, email, className, age,Id);
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.getWriter().print("sucessfully");
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><p><b>sucessfully registered</b></p><br><a href=Index.html>Home</a></body></html>");
	}

}
