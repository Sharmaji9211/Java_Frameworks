<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Student | Student Management System</title>
    <link rel="stylesheet" href="static/CSS/add.css">
</head>
<body onload="makeActive('insert')">

    <jsp:include page="menu.jsp" />

    <div class="form-container">
        <h2>Add New Student Details</h2>
        
        <form action="save-success.jsp" method="post">
        
            <div class="form-group">
                <label>Student ID</label>
                <input type="text" id="sid" name="sid" required>
            </div>

            <div class="form-group">
                <label>Student Name</label>
                <input type="text" id="name" name="name" required>
            </div>

            <div class="form-group">
                <label>Course</label>
                <input type="text" id="course" name="course" required>
            </div>

            <div class="form-group">
                <label>Mobile No</label>
                <input type="text" id="mobile" name="mobile" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="text" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label>Course Fee</label>
                <input type="text" id="fee" name="fee" required>
            </div>

            <div class="form-actions">
                <button type="submit">Save Record</button>
            </div>
            
        </form>
    </div>

</body>
</html>
