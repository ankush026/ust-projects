<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<fieldset style="width:350px">
<legend style="font-size: 30px;">SIGN UP</legend>
<form action="RegUser"  method="post" >
<pre>
<h3 style="font-family:cursive;"><b>
User Name:	    <input style="width: 200px" type="text" name="un"  required="required"><br>
Email Id: 	    <input style="width: 200px"  type="email" name="email"  required="required"><br>
Password: 	    <input style="width: 200px"  type="text" name="password"  required="required"><br>

<input  type="submit" value="Sign Up">   |  <a href="UserLogin">Login</a> 

 <a href="index.jsp">Home</a></b></h3> 
</pre>
</form>

<h1 style="color: green;">${msg }</h1>
<h1 style="color: red;">${msgf }</h1>

</fieldset>
</center>
</body>
</html><!-- pattern="^[a-z]@[a-z]*{4}.[com]$" -->


<!-- Security Question:  <input style="width: 200px"  type="text" name="secques"  required="required"><br>
 -->