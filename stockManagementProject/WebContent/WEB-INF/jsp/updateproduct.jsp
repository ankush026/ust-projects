<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update product</title>
</head>
<body>
<body>
<h1 align="center"><u>UPDATE PRODUCT</u></h1>
<br><br><br>
<h3 align="right">  <a href="Home">Home </a> | <a href="mycart">My Cart</a> |  <a href="logout">LOGOUT</a></h3>
<h3> <a href=addpage>ADD PRODUCT</a>   |   <a href="updateproduct">UPDATE PRODUCT </a> |  <a href="stock">AVAILABLE PRODUCTS / STOCK</a> </h3>
<hr>

<h3><center><table border='1'>
<tr>
<th> Product ID </th> <th> Product Name </th>  <th> Product Category </th><th> Product Company </th> <th> Product Quantity </th> 
<th> Product Price </th> <th> Update Product</th>
</tr>

<c:forEach var="plist" items="${plist }">
<form action="updatelink">
<tr>

<td><center><input type="text" name="pid" value="${plist.getPid()}" readonly="readonly"></center></td>
<td><center><input type="text" name="pname" value="${plist.getPname()}"> </center></td>
<td><center><input type="text" name="pcategory" value="${plist.getPcategory()}"></center></td>
<td><center><input type="text" name="company" value="${plist.getCompany()}"></center></td>
<td><center><input type="text" name="qty" value="${plist.getQty()}"></center></td>
<td><center><input type="text" name="price" value="${plist.getPrice()}"></center></td> 
<td><center><input type="submit" value="Update">  </center></td>

</tr>
</form>
</c:forEach>

</table>
</center>
<br><br>
<h2 align="center">click on any field to update the product detail</h2>
</center></h3>

${msg }
</body>
</body>
</html>