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
<center>
<fieldset style="width:350px">
<legend style="font-size: 30px;">LOGIN</legend>
<form action="Login"  method="post" >
<pre>
<h3 style="font-family:cursive;"><b>
Email Id:  <input type="email" name="email"  required="required"><br>
Password:  <input type="text" name="password"  required="required"><br>
<input  type="submit" value="Login"> | <a href="register">Register</a></b></h3> 
</pre>
</form>
</fieldset>
<br><br>
<h1 style="color: red;">${msgf }</h1>
</center>
</body>
</html>