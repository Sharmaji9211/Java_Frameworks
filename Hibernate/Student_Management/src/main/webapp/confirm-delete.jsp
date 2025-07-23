<%@page import="com.student.Student"%>
<%@page import="com.student.StudentService"%>
<jsp:useBean id="service" class="com.student.StudentService" scope="application" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Confirm Delete</title> 
  <link rel="stylesheet" href="static/CSS/confirm-delete.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
</head>

<body onload="makeActive('delete')">

  <jsp:include page="menu.jsp" />

<%
	Student std = service.searchStudent(request.getParameter("sid"));
	if(std!=null){
%>
  <form action="delete-success.jsp" method="get">
    <div class="confirm-box">
      <div class="confirm-header">
        <i class="fas fa-trash-alt"></i> Confirm Deletion
      </div>
      <table>
        <tr>
          <th>Student ID</th>
          <td><%=std.getSid() %></td>
          <input type="hidden" name="sid" value="<%=std.getSid() %>" />
        </tr>
        <tr>
          <th>Student Name</th>
          <td><%=std.getName() %></td>
        </tr>
        <tr>
          <th>Mobile</th>
          <td><%=std.getMobile() %></td>
        </tr>
        <tr>
          <th>Email</th>
          <td><%=std.getEmail() %></td>
        </tr>
        <tr>
          <th>Course</th>
          <td><%=std.getCourse() %></td>
        </tr>
        <tr>
          <th>Fee</th>
          <td>&#8377;<%=std.getFee() %></td>
        </tr>
      </table>

      <div class="actions">
        <span>Are you sure you want to delete?</span>
        <button type="submit" class="btn btn-yes">Yes</button>
        <button type="button" class="btn btn-no" onclick="history.back()">No</button>
      </div>
    </div>
  </form>
<%} 
	else {%>
		 <div style="text-align:center">
		    <h3 style="color:red">Given Student Id= <%=request.getParameter("sid") %> Does Not Found</h3>
		  </div>
	<%}
	%>
</body>
</html>
