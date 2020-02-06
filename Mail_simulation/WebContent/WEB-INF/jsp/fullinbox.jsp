<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INBOX</title>
</head>
<body>
<center><h1>INBOX</h1></center>
<h3 align="right">  <a href="Home">Home </a> | <a href="logout">LOGOUT</a></h3>
<h3><a href="Inbox">INBOX</a> | <a href="SentInbox">SENT </a> | <a href="deletedmsginhome">DELETED</a> | <a href="Draft">DRAFT</a> | <a href="Compose">COMPOSE</a></h3>
<hr>
<center>
<fieldset style="width:350px">
<legend></legend>
<pre>
TO:  	<input  style="width: 250px;" type="text" value="${maildto.getUto()}">


FROM:   <input  style="width: 250px;" type="text" value="${maildto.getUsent()}">

MESSAGE:  <input style="height: 150px; width: 200px;" type="text" value="${maildto.getUinbox()}">
</pre>
</fieldset>
</center>
</body>
</html>