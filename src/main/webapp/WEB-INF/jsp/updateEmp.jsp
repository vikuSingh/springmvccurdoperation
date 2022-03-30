<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Details</title>
</head>
<body>
<h1>UPDATE EMPLOYEE</h1>
<hr>   
 <c:forEach items="${ singleEmpRecords }" var="emp">
 <form action="/springmvccurdopeation/update" method="post">
  <label for="Employee ID">Employee ID:</label><br>
  <input type="text" id="eid" name="eid" value="${ emp.eid}" readonly="readonly"><br>
  <label for="Employee Name">Employee Name:</label><br>
  <input type="text" id="ename" name="ename" value="${ emp.ename}"><br>
  <label for="Salary">Salary:</label><br>
  <input type="text" id="sal" name="sal" value="${ emp.sal}"><br>
  <label for="Mobile Number">Mobile Number:</label><br>
  <input type="text" id="mobileNum" name="mobileNum" value="${ emp.mobileNum}"></br>
  <input type="submit" value="Update">
</form>
</c:forEach>
 <a href="/springmvccurdopeation/getAllEmp" method="get">VIEW EMP RECORDS</a>
</body>
</html>