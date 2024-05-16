<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h2 align="center">Employee Form</h2>
		<form action="save" method="post">

			<div class="row">
				<div class="col">
					<label class="form-label">EmpName :</label>
				</div>
				<div class="col">
					<input name="empName"  class="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label">EmpEmail :</label>
				</div>
				<div class="col">
					<input type="text" name="empEmail"  class="form-control" />
				</div>
			</div>
			
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpSal :</label>
				</div>
				<div class="col">
					<input name="empSal"  class="form-control" />
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpGender :</label>
				</div>
				<div class="col">
					<input type="radio" name="empGender" value="Male" class="form-check-input" />Male    
                     <input type="radio" name="empGender" value="Female" class="form-check-input" />Female
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label class="form-label">EmpFavColors :</label>
				</div>
				<div class="col">
					<input type="checkbox" name="empFavColors" value="RED" class="form-check-input" />RED
                     <input type="checkbox" name="empFavColors" value="GREEN" class="form-check-input" />GREEN
                     <input type="checkbox" name="empFavColors" value="BLUE" class="form-check-input" />BLUE
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label class="form-label">EmpDept :</label>
				</div>
				<div class="col">
					<select name="empDept" class="form-select">
				                   <option value="">--SELECT--</option>
				                    <option value="DEV">DEV</option>
				      				<option value="QA">QA</option>
				                    <option value="BA">BA</option>
				                    <option value="MGR">MGR</option>
			            </select>
				</div>
			</div>
			<br/>
			<div class="row">
				<div class="col">
					<label class="form-label">EmpPrjs :</label>
				</div>
				<div class="col">
					<select name="empPrjs" multiple="multiple" class="form-select" >
				                     <option value="">--SELECT--</option>
				                     <option value="HCL">HCL</option>
				                     <option value="TCS">TCS</option>
				                     <option value="WIPRO">WIPRO</option>
			                         <option value="RNT">RNT</option>
			            </select>
				</div>
			</div>
                 <br/>
			<input type="submit" value="Save Employee" class="btn btn-success">
		</form>
		${msg}
	</div>
</body>
</html>


