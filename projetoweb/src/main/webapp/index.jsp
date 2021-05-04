<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Daniel Andrade</title>
</head>
<body>

	<%
		String str = "Daniel Andrade da Silva";
		out.print(str);
	%>
	<br>
	<%= "<h1><i>Minha segunda string</i></h1>" %>
	
	<%
		request.getParameter("nome");
		request.getParameter("sobrenome");
	%>

</body>
</html>