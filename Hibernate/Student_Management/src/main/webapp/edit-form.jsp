<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Edit Student</title>

  <link rel="stylesheet" href="static/CSS/form.css">

</head>

<body onload='makeActive("edit")'>

  <!-- Include menu -->
  <jsp:include page="menu.jsp" />

  <div class="search-container">
    <div class="form-header">
      &#9998; Edit Student Record
    </div>

    <form action="show-edit-record.jsp" method="get">
      <div class="form-body">
        <div class="form-group">
          <label for="sid">Enter Student ID</label>
          <input type="text" id="sid" name="sid" required>
        </div>
        <div class="form-actions">
          <button type="submit">Show Record</button>
        </div>
      </div>
    </form>
  </div>


</body>
</html>
