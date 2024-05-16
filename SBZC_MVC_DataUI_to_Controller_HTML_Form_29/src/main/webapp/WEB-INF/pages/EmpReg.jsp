<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmpReg</title>
</head>
<body>
	<h2>EmpRegistration Form</h2>

	<form action="save" method="POST">
		<pre>
          ID      : <input type="text" name="empId"/>         
          Name    : <input type="text" name="empName"/>         
          Sal     : <input type="text" name="empSal"/>         
          Password: <input type="password" name="empPwd"/>   
          Addrs   : <textarea name="empAddr"></textarea>  
          
           Gender :
                    <input type="radio" name="empGen" value="Male" >Male 
                    <input type="radio" name="empGen" value="Female" >Female 
          
          Dept    :
                     <select name="empDept">
                               <option value="">-SELECT-</option>
                               <option value="DEV">DEV</option>
                               <option value="QA">QA</option>
                               <option value="BA">BA</option>
                     </select>   
        Lang     :
                   <input type="checkbox" name="empLang" value="ENG" >ENG 
                    <input type="checkbox" name="empLang" value="TEL" >TEL 
                    <input type="checkbox" name="empLang" value="HIN" >HIN 
                    <input type="checkbox" name="empLang" value="TIM" >TIM 
                
        Projs :
                    <select name="empProjs" multiple="multiple">
                               <option value="">-SELECT-</option>
                               <option value="HTC">HTC</option>
                               <option value="TCS">TCS</option>
                               <option value="XYZ">XYZ</option>
                               <option value="RNT">RNT</option>
                     </select>     
                     
          EmpColor  :  <input type="color" name="empColor">
          EmpDte    :  <input type="date" name="empDte">
          EmpTme    :  <input type="time" name="empTme">
          EmpDateTme:  <input type="datetime" name="empDateTme">
          EmpFile   :  <input type="file" name="empFile">
          
           <input type="submit" value="Add Emp">                           
      
      </pre>
	</form>




</body>
</html>