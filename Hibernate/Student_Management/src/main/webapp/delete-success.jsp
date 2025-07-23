<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="service" class="com.student.StudentService" scope="application" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Delete Success</title>
  <link rel="stylesheet" href="static/CSS/delete-success.css">
</head>

<body onload="makeActive('delete')">

  <!-- Include the navigation menu -->
  <jsp:include page="menu.jsp" />
  <%
     service.DeleteById(request.getParameter("sid"));
  %>
  
  <div class="success-box">
    <div class="icon">🗑️</div>
    <h2>Student Record Deleted Successfully</h2>
    <p>Student with ID <strong><%= request.getParameter("sid") %></strong> has been removed from the system.</p>
    
    <form action="student-list.jsp">
      <button class="btn">Back to Student List</button>
    </form>
  </div>

</body>
</html>
