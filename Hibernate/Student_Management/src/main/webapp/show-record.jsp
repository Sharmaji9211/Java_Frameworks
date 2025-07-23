<%@page import="com.student.Student"%>
<%@page import="com.student.StudentService"%>
<jsp:useBean id="service" class="com.student.StudentService" scope="application" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Search Result</title>

  <!-- CSS for the page -->
  <link rel="stylesheet" href="static/CSS/search-result.css">
</head>
<body onload="makeActive('search')">
 

<% 
	Student std=service.searchStudent(request.getParameter("sid"));
	if(std!=null){
%>
 <jsp:include page="menu.jsp" />
  <div class="product-card">
    <h2>Student Details</h2>
    <table>
      <tr>
        <th>Student ID</th>
        <td><%=std.getSid() %></td>
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
        <td><%=std.getFee() %></td>
      </tr>
    </table>
  </div>
<% }
	else {
	    %>
	   <jsp:include page="search-form.jsp" />
	  <div style="text-align: center">
	    <h3 style="color:red">Given Student Id= <%= request.getParameter("sid")%> Dose Not Found</h3>
	  </div>
	    <%
	}
%>

</body>
</html>
