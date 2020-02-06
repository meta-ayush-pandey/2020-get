package com.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowTable
 */
@WebServlet("/ShowTable")
public class ShowTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Statement stmt = DatabaseConnection.createConnection("StudentRegistration", "root", "root");
		String query = "select * from Student";
		ResultSet result;
		try {
			result = stmt.executeQuery(query);
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<link href=\"index.css\" rel=\"StyleSheet\"");
			out.println("<body>");
			out.println("<div class=\"outerBox\">");
			out.println("<table border=\"1px\">");
			out.println("<tr><th>SN</th><th>Firstname</th><th>Lastname</th><th>fahername</th><th>email</th><th>class</th><th>Age</th></tr>");
			while (result.next()) {
			out.println("<tr><td>" + result.getString("id") + "</td><td>"
			+ result.getString("name") + "</td><td>"
			+ result.getString("last_name") + "</td><td>"
			+ result.getString("father_name") + "</td><td>"
			+ result.getString("email") + "</td><td>"
			+ result.getString("standard") + "</td><td>"
			+ result.getString("age")
			+ "</td><td><a href=\"UpdateStudentDetail.jsp?id="+ result.getString("id") +"\">update</a></td></tr>");
			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
