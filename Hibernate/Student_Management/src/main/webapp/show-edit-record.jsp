<%@page import="com.student.StudentService"%>
<%@page import="com.student.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="service" class="com.student.StudentService" scope="application" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Student</title>
  <link rel="stylesheet" href="static/CSS/showEdit.css">
</head>

<body onload='makeActive("edit")'>

<%

 Student std= service.searchStudent(request.getParameter("sid"));
if(std!=null)	{
%>

  <jsp:include page="menu.jsp" />
  <form action="update-success.jsp" method="post">
    <table class="taf">
      <tr>
        <th colspan="2">&#9881;&#65039; Update Student Record</th>
      </tr>
      <tr>
        <td>Student ID</td>
        <td><input type="text" name="sid" class="tb" value="<%= std.getSid() %>" readonly></td>
      </tr>
      <tr>
        <td>Student Name</td>
        <td><input type="text" name="name" class="tb" value="<%= std.getName() %>" readonly></td>
      </tr>
      <tr>
        <td>Edit Student Mobile No</td>
        <td><input type="text" name="mobile" class="tb" value="<%= std.getMobile() %>" required></td>
      </tr>
      
      <tr>
        <td>Edit Student Email</td>
        <td><input type="text" name="email" class="tb" value="<%= std.getEmail() %>" required></td>
      </tr>
      
      <tr>
        <td>Edit Student Course</td>
        <td><input type="text" name="course" class="tb" value=" <%=std.getCourse() %>" required></td>
      </tr>
      
      <tr>
        <td>Edit Student Fee</td>
        <td><input type="text" name="fee" class="tb" value="<%=std.getFee() %>" required></td>
      </tr>
      
      <tr>
        <td colspan="2" align="right">
          <button type="submit" class="bt">Update</button>
          <button type="button" class="bt cancel" onclick="history.back()">Cancel</button>
        </td>
      </tr>
    </table>
  </form>
  <% }
	else {
	    %>
	   <jsp:include page="edit-form.jsp" />
	  <div style="text-align: center">
	    <h3 style="color:red">Given Student Id= <%= request.getParameter("sid")%> Dose Not Found</h3>
	  </div>
	    <%
	}
%>
</body>
</html>
