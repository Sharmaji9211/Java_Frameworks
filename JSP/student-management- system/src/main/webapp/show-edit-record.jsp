<!DOCTYPE html>
<html>
<%@ include file="menu.jsp" %>	
<head>
  <meta charset="UTF-8">
  <title>Edit Product</title>
  </head>
  <body onload='makeActive("edit")'>
    <form action="update-record" method="post">
      <table class="taf">
        <tr>
          <th colspan="2">&#9881;&#65039; Update Student Record</th>
        </tr>
        <tr>
          <td>Student ID</td>
          <td><input type="text" name="sid" class="tb" th:value="${student.sid}" readonly></td>
        </tr>
        <tr>
          <td> Student Name</td>
          <td><input type="text" name="name" class="tb" th:value="${student.name}" readonly></td>
        </tr>
        <tr>
          <td>Edit Student Mobile No</td>
          <td><input type="text" name="mobile" class="tb" th:value="${student.mobile}" required></td>
        </tr>
        <tr>
          <td>Edit Student Email</td>
          <td><input type="text" name="email" class="tb" th:value="${student.email}" required></td>
        </tr>
		<tr>
		          <td>Edit Student  Course</td>
		          <td><input type="text" name="course" class="tb" th:value="${student.course}" required></td>
		        </tr>
		        <tr>
		          <td>Edit Student Fee</td>
		          <td><input type="text" name="fee" class="tb" th:value="${student.fee}" required></td>
		        </tr>		
        <tr>
          <td colspan="2" align="right">
            <button class="bt">Update</button>
            <button type="button" class="bt cancel" onclick="history.back()">Cancel</button>
          </td>
        </tr>
      </table>
    </form>
  </body>
  </html>
