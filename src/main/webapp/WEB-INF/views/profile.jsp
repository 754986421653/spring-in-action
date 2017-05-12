<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session='false' %>
<!DOCTYPE html>
<html>
<head>
    <title>Spittr</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/public/css/style.css' />">
</head>
<body>
    <h1>Your Profile</h1>
    Username: <strong><c:out value="${spitter.username}" /></strong><br/>
    First Name: <strong><c:out value="${spitter.firstName}" /></strong><br />
    Last Name: <strong><c:out value="${spitter.lastName}" /></strong>
</body>
</html>