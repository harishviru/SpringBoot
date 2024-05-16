<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmpReg</title>
</head>
<body>
	<h2>EmpRegistration Form</h2>


    <form:form action="save" method="POST" modelAttribute="employee">
                <pre>
                 ID      :  <form:input path="empId"/>
                 Name    :  <form:input path="empName"/>
                 Sal     :  <form:input path="empSal"/>
                 Password:  <form:password path="empPwd"/>
                 Addrs   :  <form:textarea path="empAddr"/>
                 
                 Gender :
                    <form:radiobutton path="empGen" value="Male"/> Male
                    <form:radiobutton path="empGen" value="Female"/> Female
    
               Dept    :
                     <form:select path="empDept">
                              <form:option value="">-SELECT-</form:option>
                               <form:option  value="DEV">DEV</form:option>
                               <form:option  value="QA">QA</form:option>
                               <form:option value="BA">BA</form:option>
                     </form:select>   
             Lang     :
                   <form:checkbox path="empLang" value="ENG" />ENG 
                    <form:checkbox path="empLang" value="TEL" />TEL 
                    <form:checkbox path="empLang" value="HIN" />HIN 
                    <form:checkbox path="empLang" value="TIM" />TIM 
                  
        Projs :
                    <form:select path="empProjs" multiple="multiple">
                               <form:option value="">-SELECT-</form:option>
                               <form:option value="HTC">HTC</form:option>
                               <form:option value="TCS">TCS</form:option>
                               <<form:option value="XYZ">XYZ</form:option>
                               <form:option value="RNT">RNT</form:option>
                    </form:select>  
                    
          EmpColor  : <form:input  type="color" path="empColor"/>
          EmpDte    : <form:input   type="date" path="empDte" />
          EmpTme    : <form:input   type="time" path="empTme"/>
          EmpDateTme:  <form:input   type="datetime" path="empDateTme"/>
          EmpFile   :  <form:input  type="file" path="empFile"/>        
                    
                       
               <input type="submit" value="SAVE EMP">
              </pre>
    </form:form>



</body>
</html>