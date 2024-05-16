<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmpForm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container">
		<h2 align="center">Employee Update Form</h2>
		<form:form action="update" method="post" modelAttribute="employeeObj" >

			<div class="row">
				<div class="col">
					<label class="form-label">EmpId :</label>
				</div>
				<div class="col">
					<form:input path="empId" readonly="true" class="form-control" />
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpName :</label>
				</div>
				<div class="col">
					<form:input path="empName"  class="form-control" />
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpEmail :</label>
				</div>
				<div class="col">
					<form:input path="empEmail"  class="form-control" />
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpSal :</label>
				</div>
				<div class="col">
					<form:input path="empSal"  class="form-control" />
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpGender :</label>
				</div>
				<div class="col">
					<form:radiobutton path="empGender" value="Male" class="form-check-input" />Male    
                     <form:radiobutton path="empGender" value="Female" class="form-check-input" />Female
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpFavColors :</label>
				</div>
				<div class="col">
					<form:checkbox path="empFavColors" value="RED" class="form-check-input" />RED
                     <form:checkbox path="empFavColors" value="GREEN" class="form-check-input" />GREEN
                     <form:checkbox path="empFavColors" value="BLUE" class="form-check-input" />BLUE
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label">EmpDept :</label>
				</div>
				<div class="col">
					<form:select path="empDept" class="form-select">
				                   <form:option value="">--SELECT--</form:option>
				                    <form:option value="DEV">DEV</form:option>
				      				<form:option value="QA">QA</form:option>
				                    <form:option value="BA">BA</form:option>
				                    <form:option value="MGR">MGR</form:option>
			            </form:select>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label class="form-label">EmpPrjs :</label>
				</div>
				<div class="col">
					<form:select path="empPrjs" multiple="multiple" class="form-select" >
				                     <form:option value="">--SELECT--</form:option>
				                     <form:option value="HCL">HCL</form:option>
				                     <form:option value="TCS">TCS</form:option>
				                     <form:option value="WIPRO">WIPRO</form:option>
			                         <form:option value="RNT">RNT</form:option>
			            </form:select>
				</div>
			</div>
                 <br/>
			<input type="submit" value="Update Employee" class="btn btn-success">
		</form:form>
	</div>
</body>
</html>