<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Page</title>
</head>
<body>
<center>
<fieldset style="width:350px">
<legend style="font-size: 30px;">Forgot Password</legend>
<form action="forgetpass"  method="post" >
<pre>
<h3 style="font-family:cursive;"><b>

Email Id: 	  <input style="width: 200px"  type="email" name="email"  required="required"><br>
Security Question:    <select name="secques">
<option value="selected disabled"> Select Question</option>
 <option value="whats your school name"> whats your school name</option>
 <option value="whats your college name"> whats your college name</option>
  <option value="whats your pet name"> whats your pet name</option>
</select><br>
Security Answer: <input style="width: 200px"  type="text" name="secansw"  required="required"><br>
New Password: <input style="width: 200px"  type="text" name="newpassword"  required="required"><br>
Confirm Password: <input style="width: 200px"  type="text" name="confirmpassword"  required="required"><br>


<input  type="submit" value="Change Password">  |  <a href="UserLogin">Login</a> 

</pre>
</form>
${msg }
</fieldset>
</center>
</body>
</html>