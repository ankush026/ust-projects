<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1><b><u>Welcome To My Stock Management</u></b></h1></center>
<br><br>
<h3 align="right">${user} <br>
<a href="mycart">My Cart</a> |
 <a href="logout">LOGOUT</a></h3></h3> 


<h3> <a href=addpage>ADD PRODUCT</a>   |   <a href="updateproduct">UPDATE PRODUCT</a> |  <a href="stock">AVAILABLE PRODUCTS / STOCK</a>  </h3>
 
<hr><br>
<pre>
<h3>
<form action="searchproduct" method="post"> <input type="text" name="searchedproduct" placeholder="product name,category or company">  <input type="submit" value="search"> </form> 
</h3>
</pre>
<h1 style="color: green;" align="center">${msg}</h1>

</body>
</html>