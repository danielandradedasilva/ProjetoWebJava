<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Estado</title>
</head>
<body>
	<h1>Cadastro de Estado</h1>
	
	<form name="cadastroEstado" method="post" action="/projetoweb/GravaEstado">
	
		<label for="nome">Nome:</label>
		<input type="text" name="nome">
		<br>
		<label for="sigla">Sigla:</label>
		<input type="text" name="sigla">
		<br>
		<label for="codigoIbge">C�digo Ibge:</label>
		<input type="text" name="codigoIbge">
		<br>
		<input type="submit" value="Enviar">

	</form>
</body>
</html>