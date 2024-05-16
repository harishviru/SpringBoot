<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmpForm</title>
</head>
<body>

	<form action="empUpload" method="POST" enctype="multipart/form-data">
	    <pre>
		 EmpName   :<input type="text" name="empName">
		 EmpEmail  :<input type="text" name="empEmail">

		 EmpResume :<input type="file" name="empResume"> 
		<input type="submit"value="upload">
		</pre>
	</form>


</body>
</html>