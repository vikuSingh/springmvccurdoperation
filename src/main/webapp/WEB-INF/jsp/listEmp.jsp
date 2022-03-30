<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empoyee Details Page</title>
<style type="text/css">
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<h1>Employee Details</h1>
	<hr>

	<table>
		<tr>
			<th>EMP ID</th>
			<th>NAME</th>
			<th>SALARY</th>
			<th>MOB-NUM</th>
			<th>ACTION</th>
		</tr>
		<c:forEach items="${ listOfEmps }" var="emp">
			<tr>
				<td>${ emp.eid }</td>
				<td>${ emp.ename }</td>
				<td>${ emp.sal }</td>
				<td>${ emp.mobileNum }</td>
				<td><a href="/springmvccurdopeation/delete/${ emp.eid }">DELETE</a>
					| <a href="/springmvccurdopeation/update/${ emp.eid }">UPDATE</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="/springmvccurdopeation/">Add EMP</a>
	<a href="/springmvccurdopeation/report?type=xls">Download Excel</a>
	<a href="/springmvccurdopeation/report?type=pdf">Download PDF</a>

</body>
</html>