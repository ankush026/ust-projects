<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>add product</title>
</head>
<body>
<h1 align="center">Add Product Detail</h1>

<br><br><br>
<h3 align="right">  <a href="Home">Home </a> | <a href="logout">LOGOUT</a></h3>
<h3> <a href=addpage>ADD PRODUCT</a>   |   <a href="updateproduct">UPDATE PRODUCT </a> | <a href="stock">AVAILABLE PRODUCTS / STOCK</a> </h3>

<hr>
<center>
<fieldset style="width:350px">
<!-- <legend style="font-size: 30px;">Add Product Detail</legend> -->
<form action="addproduct"  method="post" >
<pre>
<h3 style="font-family:cursive;"><b>
Product Name:    <input style="width: 200px" type="text" name="pname"  required="required"><br>
Product Category:  <input style="width: 200px" type="text" name="pcategory"  required="required"><br>
Product Company:  <input style="width: 200px" type="text" name="company"  required="required"><br>
Product Quantity:  <input style="width: 200px" type="number" name="qty"  required="required"><br>
Product Price:    <input style="width: 200px" type="number" name="price"  required="required"><br>

<input  type="submit" value="Add Prodcut">    

</pre>
</form>

<h1 style="color: green;">${msg }</h1>
<h1 style="color: red;">${msgf }</h1>

</fieldset>
</center>
</body>
</html>