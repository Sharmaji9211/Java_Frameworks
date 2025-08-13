<!DOCTYPE html>
<%@page import="java.sql.*"%>
<%@ include file="menu.jsp" %>>
<html >
<head>
  <meta charset="UTF-8">
  <title>Student Management System | Add Student</title>
	</head>
	<% 
		int sid= Integer.parseInt(request.getParameter("sid"));
		String name= request.getParameter("name");
		String course= request.getParameter("course");
		String mobile= request.getParameter("mobile");
		String email= request.getParameter("email");
		String fee= request.getParameter("fee");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp5?createDatabaseIfNotExist=true","root","972027");
	    Statement s = cn.createStatement();
	    s.execute("Create table if not exists studentinfo (sid int primary key , name varchar(40),course varchar(40),moible varchar(40),email varchar(40),coursefee varchar(40) )");
	    PreparedStatement p  = cn.prepareStatement("insert into studentinfo values ( ?, ? ,? ,? ,?,?)");
	    p.setInt(1, sid);
	    p.setString(2, name);
	    p.setString(3, course);
	    p.setString(4, mobile);
	    p.setString(5, email);
	    p.setString(6, fee);
	    p.executeUpdate();
	%>
	<body onload="makeActive('insert')">
	   <div class="success-container">
	  	 <h2 class="success-message">Student record has been inserted successfully!</h2>
	   	 <a href="home.jsp" class="btn">Back to Student List</a>
	   </div>
	</body>
	</html>