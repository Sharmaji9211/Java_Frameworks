<!DOCTYPE html>
<%@page import="java.sql.*"%>
<html lang="en" >
<%@ include file="menu.jsp" %>
<head>
	<title>Student Data  Table</title>
</head>
<body onload="makeActive('list')">
	
	<table id="studentTable">
		<thead>
			<tr>
				<th onclick="sortTable(0)">Student ID</th>
				<th onclick="sortTable(1)">Student Name</th>
				<th >Mobile</th>
				<th>Email</th>
				<th>Course</th>
				<th onclick="sortTable(2)">Fee</th>
			</tr>
		</thead>
		<%

	 Class.forName("com.mysql.cj.jdbc.Driver");
	 Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp5?createDatabaseIfNotExist=true","root","972027");
	 PreparedStatement p  = cn.prepareStatement("select * from studentinfo");
	 ResultSet  rst=p.executeQuery();
	
	while(rst.next()){
	 %>
		
		
		<tbody>
			<tr>
			        <td ><%=rst.getInt(1) %></td>
			        <td ><%=rst.getString(2) %></td>
			        <td ><%=rst.getString(3) %></td>
			        <td ><%=rst.getString(4) %></td>
					<td ><%=rst.getString(5) %></td>
					<td ><%=rst.getString(6) %></td></tr>
					<%} %>
		</tbody>
		
	</table>
	<script>
		function sortTable(columnIndex) {
		      const table = document.getElementById("studentTable");
		      const tbody = table.tBodies[0];
		      const rows = Array.from(tbody.rows);

		      const isNumeric = !isNaN(rows[0].cells[columnIndex].textContent.trim());

		      const sortedRows = rows.sort((a, b) => {
		        const aText = a.cells[columnIndex].textContent.trim();
		        const bText = b.cells[columnIndex].textContent.trim();

		        return isNumeric
		          ? parseFloat(aText) - parseFloat(bText)
		          : aText.localeCompare(bText);
		      });

		      sortedRows.forEach(row => tbody.appendChild(row));
		    }
		  </script>
	</script>
</body>