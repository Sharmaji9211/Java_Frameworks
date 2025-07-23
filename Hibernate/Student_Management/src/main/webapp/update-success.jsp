<%@page import="com.student.StudentService"%>
<%@page import="com.student.Student"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="service" class="com.student.StudentService" scope="application" />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Update Confirmation</title>
  <link rel="stylesheet" href="static/CSS/update.css">
</head>

<body onload="makeActive('edit')">
  <jsp:include page="menu.jsp" />
<% 
	service.UpdateRecord(request);
%>
  <div class="confirmation-container">
    <h2>&#x2705; Student Updated Successfully</h2>
    <p>Student record with ID <strong><%= request.getParameter("sid") %></strong> has been updated in the database.</p>

    <div class="btn-group">
      <button class="btn btn-home" onclick="location.href='index.jsp'">Home</button>
      <button class="btn btn-back" onclick="history.back()">Back</button>
    </div>
  </div>
</body>
</html>
