<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Delete Student Record</title>
  
  <!-- Link to CSS -->
  <link rel="stylesheet" href="static/CSS/delete.css">
</head>

<body onload="makeActive('delete')">

  <jsp:include page="menu.jsp" />

  <div class="delete-form">
    <div class="form-header">
      🗑️ Delete Student Record
    </div>

    <form action="confirm-delete.jsp" method="get">
      <div class="form-body">
        <div class="form-group">
          <label for="sid">Enter Student ID</label>
          <input type="text" id="sid" name="sid" required>
        </div>
        <div class="form-actions">
          <button type="submit">Delete Record</button>
        </div>
      </div>
    </form>
  </div>

 

</body>
</html>
