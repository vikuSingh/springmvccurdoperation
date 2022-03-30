<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
</head>
<body>
  
  <h1>ADD EMPLOYEE</h1>
  
  <form action="/springmvccurdopeation/save" method="post">
  <label for="Employee Name">Employee Name:</label><br>
  <input type="text" id="ename" name="ename"><br>
  <label for="Salary">Salary:</label><br>
  <input type="text" id="sal" name="sal"><br>
  <label for="Mobile Number">Mobile Number:</label><br>
  <input type="text" id="mobileNum" name="mobileNum"></br>
  <input type="submit" value="Submit">
</form>
 <a href="/springmvccurdopeation/getAllEmp" method="get">VIEW EMP RECORDS</a>
</body>
</html>