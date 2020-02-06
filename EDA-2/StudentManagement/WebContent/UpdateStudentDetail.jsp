<%@page import="com.Student.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "com.Student.*"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");

Statement stmt = DatabaseConnection.createConnection("StudentRegistration","root","root");
System.out.print("conncected");
String query  = String.format("Select * from student where id=%s", id);
System.out.print("query to select is about to execut");
ResultSet result=stmt.executeQuery(query);
System.out.print("executed");
result.next();

String firstName = result.getString("name");
String lastName = result.getString("last_name");
String fatherName = result.getString("father_name");
String email = result.getString("email");
String className = result.getString("standard");
String age = result.getString("age");
%>
<form id="registerStudent" onsubmit="return validate()" method = "post" action = "update">
   Id         : <input id = "id"   type = "text" value = "<%= id %>"  name = "id" readonly /><br>
   First Name : <input type = "text" name = "fname" placeholder="first name" value="<%= firstName %>" required /><br>
   Last Name  : <input type = "text" name = "lname" placeholder="last name" value="<%= lastName %>" required /><br>
   Father Name: <input type = "text" name = "father_name" placeholder="father's name" value="<%= fatherName %>" required /><br>
   Email      : <input type = "text" name = "email" placeholder = "abc@mn.com" value="<%= email %>" required><br>
    
    
    
     
   Age        :  <input type = "text" name = "age" placeholder = "age" value="<%= age %>" required /><br>
     
  Class       : <input type="number" value="<%= className %>" name="class" min="1" max="12" >
   	 
     <input type="submit" value="Submit">
</form>
</body>
</html>