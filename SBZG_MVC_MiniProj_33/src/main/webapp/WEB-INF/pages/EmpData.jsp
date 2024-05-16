<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >

<title>EmpData</title>
</head>
<body>
   <div class="container">
	<h2 align="center">Employee Information</h2>
	<table class="table table-hover">
		<tr>
			<th>EmpId</th>
			<th>EmpName</th>
			<th>EmpEmail</th>
			<th>EmpSal</th>
			<th>EmpGender</th>
			<th>EmpFavColors</th>
			<th>EmpHr</th>
			<th>EmpDa</th>
			<th>EmpDept</th>
			<th>EmpPrjs</th>
			<th>LINK</th>
		</tr>

		<c:forEach items="${empList}" var="emp">
			<tr>
				<td>${emp.empId}</td>
				<td>${emp.empName}</td>
				<td>${emp.empEmail}</td>
				<td>${emp.empSal}</td>
				<td>${emp.empGender}</td>
				<td>${emp.empFavColors}</td>
				<td>${emp.empHr}</td>
				<td>${emp.empDa}</td>
				<td>${emp.empDept}</td>
				<td>${emp.empPrjs}</td>
				<td><a href="edit?empId=${emp.empId}" class="btn btn-success">UPDATE</a></td>
				<td><a href="delete?empId=${emp.empId}" class="btn btn-danger">DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br>
	 Total Records : <b> ${page.getTotalElements()}</b>
	<br>

     <c:if test="${!page.isFirst()}">
        <a href="?page=0"><b> FIRST</b></a> &nbsp;
     </c:if>  

     <c:if test="${page.hasPrevious()}">
        <a href="?page=${page.getNumber()-1}"><b> PREVIOUS</b></a> &nbsp;
     </c:if>  

	<c:forEach begin="0" end="${page.getTotalPages()-1}" varStatus="loop">
            <a href="?page=${loop.index}"><b> ${loop.index+1} </b></a> &nbsp;
	</c:forEach>
	
	  <c:if test="${page.hasNext()}">
        <a href="?page=${page.getNumber()+1}"><b> NEXT </b></a> &nbsp;
     </c:if>  

     <c:if test="${!page.isLast()}">
        <a href="?page=${page.getTotalPages()-1}"><b> LAST</b></a> &nbsp;
     </c:if>  
</div>
</body>
</html>