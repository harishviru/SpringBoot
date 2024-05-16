<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
  <%@taglib prefix="c" uri="jakarta.tags.core" %>  <!-- Core Lib for : forEach -->  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" >
</head>
<body>

    <h1 align="center">Welcome to UserDataPage </h1>
    
     Primitive Type   : ${id} , ${name} ,${rating}   <br>
     
     Object Type    i):  ${userObj}                  <br>
                   ii):  ${userObj.userId}  , ${userObj.userName} ,${userObj.addrs} <br>
      
      <hr>              

    List<String> Type       i): ${alphaList}        <br>
                           ii): ${alphaList[0]} ,${alphaList[1]} ,${alphaList[2]} ,${alphaList[3]} ,${alphaList[4]} 
     
     
     <hr>  
     List<User> Type       i): ${userList}     <br>
     
     <table class="table">
         <tr>
           <th scope="col">UserId</th>
           <th scope="col">UserName</th>
           <th scope="col">Addrs</th>
         </tr>
         <c:forEach items="${userList}" var="userObj">
            <tr scope="row">
              <td>${userObj.userId}</td>
              <td>${userObj.userName}</td>
              <td>${userObj.addrs}</td>
           </tr>
         </c:forEach>
     </table>
     
     
     

</body>
</html>