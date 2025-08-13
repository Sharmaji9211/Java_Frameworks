<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Search Result</title>
</head>
<%
 int sid= Integer.parseInt(request.getParameter("sid"));
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp5?createDatabaseIfNotExist=true","root","972027");
	 PreparedStatement p  = cn.prepareStatement("select * from studentinfo where sid= ?");
	 p.setInt(1, sid);
	 ResultSet  rst=p.executeQuery();
	 if(rst.next()){
	 %>
<body onload='makeActive("search")'>
  <%@ include file="menu.jsp" %>
  <div class="product-card">
    <h2>Student Details</h2>
    <table>
      <tr>
        <th>Student Id</th>
        <td ><%=rst.getInt(1)%></td>
      </tr>
      <tr>
        <th>Student Name</th>
        <td ><%= rst.getString(2) %></td>
      </tr>
      <tr>
        <th>Mobile</th>
        <td><%= rst.getString(3) %></td>
      </tr>
      <tr>
        <th>Email</th>
        <td ><%= rst.getString(4) %></td>
      </tr>
	  <tr>
		          <th>Course</th>
		          <td ><%= rst.getString(5) %></td>
		        </tr>
		        <tr>
		          <th>Fee</th>
		          <td ><%= rst.getString(6) %></td>
		        </tr>	  
    </table>
      <%}
	      %>
  </div>
</body>
</html>
