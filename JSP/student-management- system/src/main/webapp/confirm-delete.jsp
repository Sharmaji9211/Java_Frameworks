<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html >
<%@ include file="menu.jsp" %>
<head>
  <meta charset="UTF-8">
  <title>Confirm Delete</title> 
	</head>
	<body onload='makeActive("delete")'>
	 <%
	 int sid= Integer.parseInt(request.getParameter("sid"));
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp5?createDatabaseIfNotExist=true","root","972027");
	 PreparedStatement p  = cn.prepareStatement("select* from studentinfo where sid= ?");
	 p.setInt(1, sid);
	 ResultSet rst=p.executeQuery();
	 if(rst.next()){
	 %>
	  <form action="delete-success.jsp" method="get">
	    <div class="confirm-box">
	      <div class="confirm-header">
	        <i class="fas fa-trash-alt"></i> Confirm Deletion
	      </div>
	      <table>
	        <tr>
	          <th>Student ID</th>
	          <td > <%= rst.getInt(1) %></td>
			  <input type="hidden" name="sid" value="<%=request.getParameter("sid") %>">
	        </tr>
	        <tr>
	          <th>Student Name</th>
	          <td ><%= rst.getString(2) %></td>
	        </tr>
	        <tr>
	          <th> Mobile</th>
	          <td ><%= rst.getString(3) %></td>
	        </tr>
	        <tr>
	          <th> Email</th>
	          <td><%= rst.getString(4) %></td>
	        </tr>
			<tr>
			<th> course</th>
			<td ><%= rst.getString(5) %></td>
				</tr>
			    <tr>
			        <th>Fee</th>
			          <td ><%= rst.getString(6) %></td>
			        </tr>
	      </table>
	      <%}
	      %>
	      <div class="actions">
	        <span>Are you sure you want to delete?</span>
	        <button type="submit" class="btn btn-yes">Yes</button>
	        <button type="button" class="btn btn-no" onclick="history.back()">No</button>
	      </div>
	    </div>
	  </form>
	</body>
	</html>