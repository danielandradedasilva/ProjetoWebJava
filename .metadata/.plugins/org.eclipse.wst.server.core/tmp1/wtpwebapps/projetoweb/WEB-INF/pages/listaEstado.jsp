<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Estados</title>
</head>
<body>

	<h1 align="center">Lista de Estados</h1>

	<fieldset>
		<legend>Filtro</legend>
		<form action="ListaEstado" method="post">
			Nome: <input type="text" name="nomeEstadoPesquisa" value="${nomeEstadoPesquisaParam}">
			
			<input type="submit" value="Pesquisar Estado">
		</form>
	</fieldset>

	<br> <br>

	<table width="100%" border="1 px">
		<tr>
			<td width="33%" align="center">Nome</td>
			<td width="33%" align="center">Sigla</td>
			<td width="34%" align="center">C&oacute;digo IBGE</td>
		</tr>
		
		<c:forEach var="meuEstado" items="${estados}">
		<tr>
			<td>
				<c:url var="minhaUrl" value="/CadastroEstado">				
					<c:param name="idEstado">${meuEstado.idEstado}</c:param> <!-- url = /projetoweb/CadastroEstado?idEstado=${meuEstado.idEstado} -->			
				</c:url>			
				<a href="${minhaUrl}">${meuEstado.nome}</a>					
			</td>
			<td>${meuEstado.sigla}</td>
			<td>${meuEstado.codigoIbge}</td>
		</tr>
		
		</c:forEach>	
	</table>
	
	<br> <br>
	
	<form action="CadastroEstado" method="post">
		<input type="submit" value="Cadastrar Novo Estado">
	</form>
	
</body>
</html>