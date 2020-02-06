<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>COMPOSE</h1></center>
<h3 align="right">  <a href="Home">Home </a> | <a href="logout">LOGOUT</a></h3>
<h3><a href="Inbox">INBOX</a> | <a href="SentInbox">SENT </a> | <a href="deletedmsginhome">DELETED</a> | <a href="Draft">DRAFT</a> | <a href="Compose">COMPOSE</a></h3>
<hr>
<center>
<fieldset style="width:350px">
<form action="Sent"  method="post" >
<pre>


To:      <input style="width: 200px;" type="email" name="email"  value="${maildto.getUdraft()}" required="required"><br><br>

Subject:  <input  style="height: 50pxpx; width: 200px; " type="text"  name="usub" value="${maildto.getUsent()}"><br><br>
Message:  <input  style="height: 150px; width: 200px;" type="text"  name="uinbox" value="${maildto.getUinbox()}"><br><br>

 <input style="width: 80px" type="submit" value=" Sent"></b>
</form></pre>
${draftmsg }
</center>
</body>
</html>