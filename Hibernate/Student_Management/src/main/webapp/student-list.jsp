<%@page import="com.student.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.student.StudentService"%>
<jsp:useBean id="service" class="com.student.StudentService" scope="application" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Student Data Table</title>
	<link rel="stylesheet" href="static/CSS/studentList.css">
</head>
<body onload="makeActive('list')">
	<jsp:include page="menu.jsp" />
	<% 
		List<Student> studentList = service.getAllStudents();
	%>
	<table id="studentTable">
		<thead>
			<tr>
				<th onclick="sortTable(0)">Student ID</th>
				<th onclick="sortTable(1)">Student Name</th>
				<th>Mobile</th>
				<th>Email</th>
				<th>Course</th>
				<th onclick="sortTable(5)">Fee</th>
			</tr>
		</thead>
		<tbody>
			<%
			 for(Student std : studentList){
			%>
				<tr>
					<td data-label="Student ID"><%=std.getSid() %></td>
					<td data-label="Student Name"><%=std.getName() %></td>
					<td data-label="Mobile"><%=std.getMobile() %></td>
					<td data-label="Email"><%=std.getEmail() %></td>
					<td data-label="Course"><%=std.getCourse() %></td>
					<td data-label="Fee"><%=std.getFee()%></td>
				</tr>
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

</body>
</html>
