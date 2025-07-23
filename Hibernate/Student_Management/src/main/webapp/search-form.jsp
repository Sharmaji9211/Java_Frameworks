<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Search Student</title>
  <link rel="stylesheet" href="static/CSS/search.css">
</head>

<body onload='makeActive("search")'>
  <jsp:include page="menu.jsp" />

  <div class="search-container">
    <div class="form-header">
      🔍 Search Student
    </div>

    <form action="show-record.jsp" method="get">
      <div class="form-body">
        <div class="form-group">
          <label for="sid">Enter Student ID</label>
          <input type="text" id="sid" name="sid" required>
        </div>
        <div class="form-actions">
          <button type="submit">Search Record</button>
        </div>
      </div>
    </form>
  </div>

  

</body>
</html>
