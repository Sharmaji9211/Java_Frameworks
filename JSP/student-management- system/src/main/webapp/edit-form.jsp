
<!DOCTYPE html>
<html >
<%@ include file="menu.jsp" %>	
<head>
  <meta charset="UTF-8">
  <title>Search Product</title>
  <link rel="stylesheet" href="CSS/form.css"> <!-- Shared form styles -->
  <style>
	 </style>
	</head>
	<body onload='makeActive("edit")'>
	  <div class="search-container">
	    <div class="form-header">
	      &#9998; Edit Student Record
	    </div>
	    <form action="edit-record" method="get">
	      <div class="form-body">
	        <div class="form-group">
	          <label for="pid">Enter Student ID</label>
	          <input type="text" id="sid" th:value="${sid}" name="sid" required>
	        </div>
	        <div class="form-actions">
	          <button type="submit">Show Record</button>
	        </div>
	      </div>
	    </form>
	  </div>
	   <div style="text-align: center">
	   <h3 style="color:red" th:text="${msg}"></h3>
	  </div>
	</body>
	</html>
