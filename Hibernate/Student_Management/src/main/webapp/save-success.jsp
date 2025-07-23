<%@page import="com.student.StudentService"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Student Management System | Add Student</title>
  <link rel="stylesheet" href="static/CSS/save.css">
</head>
<body onload="makeActive('insert')">
<%StudentService.addStudent(request);%>
  <div class="success-container">
    <h2 class="success-message">Student record has been inserted successfully!</h2>
    <a href="student-list.jsp" class="btn">Back to Student List</a>
  </div>
</body>
</html>
