<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html >
<%@ include file="menu.jsp" %>	
<head>
  <meta charset="UTF-8">
  <title>Delete Success</title>
  </head>
  <body onload='makeActive("delete")'>
  <% 
    int sid= Integer.parseInt(request.getParameter("sid"));
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp5?createDatabaseIfNotExist=true","root","972027");
	 PreparedStatement p  = cn.prepareStatement("delete from studentinfo where sid= ?");
	 p.setInt(1, sid);
	 int rst=p.executeUpdate();
	 %>
  <div class="success-box">
    <div class="icon">🗑️</div>
    <h2>Student Record Deleted Successfully</h2>
    <p>Student have ID <strong ><%=sid %></strong> has been removed from the system.</p>
    <form action="student-list.jsp">
      <button class="btn">Back to Product List</button>
    </form>
  </div>
  </body>
  </html>