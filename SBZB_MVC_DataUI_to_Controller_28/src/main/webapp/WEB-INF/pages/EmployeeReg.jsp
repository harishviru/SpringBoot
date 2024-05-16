<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeReg</title>
</head>
<body>
          <h1> Welcome to Employee Register Page</h1>
          <hr/>
          <form action="add" method="POST">
             <pre>
                ID   : <input type="text" name="empId">
                Name : <input type="text" name="empName">
                Sal  : <input type="text" name="empSal">
                 <input type="submit" value="Register">
             </pre>
          </form>
</body>
</html>