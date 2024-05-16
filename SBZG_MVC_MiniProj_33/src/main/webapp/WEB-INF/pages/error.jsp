<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ERROR</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >

</head>
<body>

     <div class="container">
	<h2 align="center">SOMETHING WENT WRONG .PLEASE CONTACT ADMIN</h2>
	<table class="table table-striped">
		<tr>
			<th>Timestamp</th>
			<th>Status</th>
			<th>Message</th>
			<th>Path</th>
			<th>Error Trace</th>
		</tr>
			<tr>
				<td>${timestamp}</td>
				<td>${status}</td>
				<td>${message}</td>
				<td>${path}</td>
				<td>${error}</td>
			</tr>
	</table>
	</div>
     
     
</body>
</html>