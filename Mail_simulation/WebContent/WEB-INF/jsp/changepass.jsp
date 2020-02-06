<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>


<center>
<fieldset style="width:350px">
<legend style="font-size: 30px;">Change Password</legend>
<form action="changepassword"  method="post" >
<pre>
<h3 style="font-family:cursive;"><b>

Email Id:     	  <input style="width: 200px"  type="text" name="email" value="${email }" required="required"><br>
New Password:   <input style="width: 200px"  type="text" name="newpassword"  required="required"><br>
Confirm Password:  <input style="width: 200px"  type="text" name="confirmpassword"  required="required"><br>

<input  type="submit" value="Change Password"> | <a href="Home">Home </a> 

</pre>
</form>

${msg}
</fieldset>
</center>
</body>
</html>