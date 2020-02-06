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

<center><h1>SENT</h1></center>

<h3 align="right">  <a href="Home">Home </a> | <a href="logout">LOGOUT</a></h3>
<h3><a href="Inbox">INBOX</a> | <a href="SentInbox">SENT </a> | <a href="deletedmsginhome">DELETED</a> | <a href="Draft">DRAFT</a> | <a href="Compose">COMPOSE</a></h3>
<hr>
<h3><center><table border='1'><tr><th>Sent To</th><th>Messages</th> <th>Delete</th></tr>
<c:forEach var="idto" items="${plist}">
<tr><td><center>${idto.getUto() }</center></td>
<td><center>${idto.getUinbox() }</center></td>
<td><center><a href="deletemsg?msgid=${idto.getInfid()}"> Delete</a></center></td>

</tr>
</c:forEach>
</table>

</body>
</html>