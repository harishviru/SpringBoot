<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Welcome to APP</title>
</head>
<body>
    <h2> Welcome to Hello World </h2> 
    <%= new java.util.Date() %>
    <% response.addHeader("refresh","5"); %>
</body>
</html>