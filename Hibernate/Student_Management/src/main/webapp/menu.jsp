<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Management System</title>
    
    <!-- Link CSS and JS using context path -->
    <link rel="stylesheet" href="static/CSS/menu.css">
    <script src="static/JS/menu.js"></script>
</head>

<body>
    <nav class="navbar">
        <div class="nav-container">
            <div class="brand">STUDENT MANAGEMENT SYSTEM</div>
            <ul class="nav-menu">
                <li><a id="home" href="">Home</a></li>
                <li><a id="insert" href="add-student-form.jsp">Add Student</a></li>
                <li><a id="list" href="student-list.jsp">View All Students</a></li>
                <li><a id="delete" href="delete-form.jsp">Delete Record</a></li>
                <li><a id="edit" href="edit-form.jsp">Edit Record</a></li>
                <li><a id="search" href="search-form.jsp">Search Record</a></li>
            </ul>
        </div>
    </nav>
</body>
</html>
