<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session='false' %>
<!DOCTYPE html>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/public/css/style.css' />">
</head>
<body>
	<h1>Welcome to Spittr</h1>
	<a href="<c:url value='/spittles' />">Spittles</a> |
	<a href="<c:url value='/spitter/register' />">Register</a>
</body>
</html>