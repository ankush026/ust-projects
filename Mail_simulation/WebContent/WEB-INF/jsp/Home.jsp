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
<h1><b>Welcome To My Gmail App</b></h1>
<br><br>
<h3 align="right">${user} <br>
<a href="changepass">Change Password</a> | <a href="logout">LOGOUT</a></h3></h3> 
<hr>

<h3>
<a href="Inbox">INBOX</a> | <a href="SentInbox">SENT </a> | <a href="deletedmsginhome">DELETED</a> | <a href="Draft">DRAFT</a> | <a href="Compose">COMPOSE</a></h3>

<h1 style="color: green;" align="center">${msg}</h1>

</body>
</html>