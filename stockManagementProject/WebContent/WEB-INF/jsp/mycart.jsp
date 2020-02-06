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
<center><h1><b><u>My Cart</u></b></h1></center>
<br><br>
<h3 align="right">${user} <br>
<a href="Home">Home </a> |
<a href="mycart">My Cart</a> |
 <a href="logout">LOGOUT</a></h3></h3> 


<h3> <a href=addpage>ADD PRODUCT</a>   |   <a href="updateproduct">UPDATE PRODUCT</a> |  <a href="stock">AVAILABLE PRODUCTS / STOCK</a>  </h3>
<hr><br>
<h3><center><table border='1'>
<tr>
<th>Product ID</th> <th>Product Name</th>  <th> Product Category </th><th> Product Company </th> <th> Product Quantity </th>
<th>Product Price</th><th>Total Price</th> <th> Total Price with GST</th>
 </tr>
<c:forEach var="bill" items="${bill }">
<tr>
 <td><center><c:forEach var="bill2" items="${bill.getP_o_list() }">  ${bill2.getPid() }</c:forEach></center></td>
 <td><center><c:forEach var="bill2" items="${bill.getP_o_list() }">  ${bill2.getPname() }</c:forEach></center></td>
 <td><center><c:forEach var="bill2" items="${bill.getP_o_list() }">  ${bill2.getPcategory() }</c:forEach></center></td>
 <td><center><c:forEach var="bill2" items="${bill.getP_o_list() }">  ${bill2.getCompany() }</c:forEach></center></td>
 <td><center><c:forEach var="bill2" items="${bill.getP_o_list() }">  1</c:forEach></center></td>
 <td><center><c:forEach var="bill2" items="${bill.getP_o_list() }">  ${bill2.getPrice() }</c:forEach></center></td>
 
 <td><center>${bill.getTotalprice() }</center></td>
<td><center>${bill.getTotalPriceWithGst() }</center></td> 

</tr>
</c:forEach>

</table>
</center>

</center></h3>

<h1>${msg}</h1>
</body>
</html>