<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FileUploadForm</title>
</head>
<body>
       
        <form action="upload" method="POST" enctype="multipart/form-data">
           <input type="file" name="file">
           <input type="submit" value="upload">
        </form>


</body>
</html>