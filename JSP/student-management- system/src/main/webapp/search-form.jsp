<!DOCTYPE html>
<html>
<%@ include file="menu.jsp" %>
<head>
  <meta charset="UTF-8">
  <title>Search Product</title>
  <link rel="stylesheet" href="CSS/form.css"> <!-- Shared form styles -->
  <style>
	  </style>
	</head>
	<body onload='makeActive("search")'>
	  <div class="search-container">
	    <div class="form-header">
	      &#128269; Search Student
	    </div>
	    <form action="show-record.jsp" method="get">
	      <div class="form-body">
	        <div class="form-group">
	          <label for="pid">Enter Student ID</label>
	          <input type="text" id="sid" value="${sid}" name="sid" required>
	        </div>
	        <div class="form-actions">
	          <button type="submit">Search Record</button>
	        </div>
	      </div>
	    </form>
	  </div>
	  <div style="text-align: center">
	   <h3 style="color:red" "${msg}"></h3>
	  </div>
	</body>
	</html>