<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session='false' %>
<!DOCTYPE html>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/public/css/style.css' />">
</head>
<body>
	<h1>View spittle</h1>
	<div class="spittleView">
	<div class="spittleMessage"><c:out value="${spittle.message}" /></div>
	<div>
		<span class="spittleTime"><c:out value="${spittle.time}" /></span>
	</div>
</div>
</body>
</html>