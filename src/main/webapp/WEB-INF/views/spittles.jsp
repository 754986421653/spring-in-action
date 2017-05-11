<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page session='false' %>
<!DOCTYPE html>
<html>
<head>
	<title>Spittr</title>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/public/css/style.css' />">
</head>
<body>
	<h1>List of spittles</h1>
	<ul>
		<c:forEach items="${spittleList}" var="spittle">
			<li id="spittle_<c:out value='spittle.id'>">
				<div class="spittleMessage">
					<c:out value="${spittle.message}" />
				</div>
				<div>
					<span class="spittleTime"><c:out value="${spittle.time}" /></span>
					<span class="spittleLocation">
						(<c:out value="${spittle.latitude}" />, <c:out value="${spittle.longitude}" />)
					</span>
				</div>
			</li>
		</c:forEach>
	</ul>
</body>
</html>