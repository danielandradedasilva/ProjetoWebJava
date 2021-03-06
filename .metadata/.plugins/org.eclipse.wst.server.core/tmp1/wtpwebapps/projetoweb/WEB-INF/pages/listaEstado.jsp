<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Projeto Web</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<style type="text/css">
	body{
		background: #fff;
	}

</style>
</head>
<body>

	<div class="container mt-5">
	
		<h1 align="center">Lista de Estados</h1>
	
		<fieldset>
			<legend>Filtro</legend>
			<div class="input-group">
				<form action="ListaEstado" method="post">
					<input type="text" placeholder="Digite o nome do Estado" class="form-control mb-3" name="nomeEstadoPesquisa" value="${nomeEstadoPesquisaParam}">					
					<input type="submit"  class="btn btn-outline-primary" value="Pesquisar Estado">
				</form>
			</div>
		</fieldset>
	
		<br>
	
		<table  class="table table-striped table-hover">
			<tr>
				<td width="33%" align="center">Nome</td>
				<td width="33%" align="center">Sigla</td>
				<td width="34%" align="center">C&oacute;digo IBGE</td>
			</tr>
			
			<c:forEach var="meuEstado" items="${estados}">
			<tr>
				<td align="center">
					<c:url var="minhaUrl" value="/CadastroEstado">				
						<c:param name="idEstado">${meuEstado.idEstado}</c:param> <!-- url = /projetoweb/CadastroEstado?idEstado=${meuEstado.idEstado} -->			
					</c:url>			
					<a href="${minhaUrl}">${meuEstado.nome}</a>					
				</td>
				<td align="center">${meuEstado.sigla}</td>
				<td align="center">${meuEstado.codigoIbge}</td>
			</tr>
			
			</c:forEach>	
		</table>
		
		<br> <br>
		
		<form action="CadastroEstado" method="post">
			<input type="submit" class="btn btn-primary d-grid gap-2 col-6 mx-auto" value="Cadastrar Estado">
		</form>
		
	</div>
	
	
</body>
</html>