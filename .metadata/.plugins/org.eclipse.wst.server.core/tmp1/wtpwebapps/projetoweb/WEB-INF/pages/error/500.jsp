<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<style type="text/css">

	body{
		background: rgba(230, 200, 80, 0.8);
	}
	.error{
		text-align:center;
		margin-top: 300px;
		color:red;
		font-size: 65px;
	}
	.error2{
		text-align:center;
		margin-top: 100px;
		color:red;
		font-size: 45px;
	}
</style>
</head>
<body>

	<h1 class="error">Putz, Erro 500, caiu a casa.</h1>	
	<h2 class="error2">Exception:${exception.message}</h2>
	
	<c:forEach var="stackTrace" items="${exception.stackTrace}">
		${stackTrace}
	</c:forEach>
</body>
</html>