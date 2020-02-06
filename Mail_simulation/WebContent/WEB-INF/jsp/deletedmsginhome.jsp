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
<center><h1>DELETED MAILS</h1></center>

<h3 align="right">  <a href="Home">Home </a> | <a href="logout">LOGOUT</a></h3>
<h3><a href="Inbox">INBOX</a> | <a href="SentInbox">SENT </a> | <a href="deletedmsginhome">DELETED</a> | <a href="Draft">DRAFT</a> | <a href="Compose">COMPOSE</a></h3>
<hr>

<h3><center><table border='1'><tr><th> Subject </th><th>Deleted Mails</th><th>Sent To</th> <th>Sent From</th>  <th>Delete</th></tr>
<c:forEach var="idto" items="${dlist}">
<tr>
<td><center> ${idto.getUsub() }</center></td>
<td><center>${idto.getUinbox() }</center></td>
<td><center>${idto.getUto() }</center></td>
<td><center>${idto.getUsent() }</center></td> 
<td><center><a href="perdelete?msgid=${idto.getInfid()}"> Delete</a></center></td> 

   
</tr>
</c:forEach>
</table>
</center></h3>
</body>
</html>