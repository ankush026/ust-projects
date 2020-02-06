<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stock Page</title>
</head>
<body>
<h1 align="center"><u>ALL PRODUCT AVAILABLE</u></h1>
<br><br><br>
<h3 align="right">  <a href="Home">Home </a> | <a href="mycart">My Cart</a> | <a href="logout">LOGOUT</a></h3>
<h3> <a href=addpage>ADD PRODUCT</a>   |   <a href="updateproduct">UPDATE PRODUCT </a> |  <a href="stock">AVAILABLE PRODUCTS / STOCK</a> </h3>


<hr>
<h3>
<form action="searchproduct" method="post"> <input type="text" name="searchedproduct" placeholder="product name,category or company">  <input type="submit" value="search"> </form> 
</h3>
<h3><center><table border='1'>
<tr>
<th>Product ID</th> <th>Product Name</th>  <th> Product Category </th><th> Product Company </th> <th> Product Quantity </th>
<th>Product Price</th><th> Add to Cart</th>
 </tr>
<c:forEach var="plist" items="${plist }">
<tr>

<td><center>${plist.getPid() }</center></td>
<td><center>${plist.getPname() }</center></td>
<td><center>${plist.getPcategory() }</center></td>
<td><center>${plist.getCompany() }</center></td>
<td><center>${plist.getQty() }</center></td>
<td><center>${plist.getPrice() }</center></td> 
<td><center> <button><a href="addtocart?pid=${plist.getPid()}"> ADD to Cart</a></button></center></td>

</tr>
</c:forEach>

</table>
</center>

<br><br>
<h2 align="center">click on My Cart Option to See your total bill</h2>
</center></h3>

${msg }
</body>
</html>