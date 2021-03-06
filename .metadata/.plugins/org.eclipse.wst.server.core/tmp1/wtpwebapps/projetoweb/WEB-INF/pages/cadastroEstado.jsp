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
		.error{color: red;}
		.divForm{margin-left: 38%;}
		.form{width: 300px;}
		.inpMn{width: 80px;}
		body{background-color: #fff}
	</style>
	
	<script type="text/javascript">	
		function excluirEstado() {
			const removeEstadoForm = document.getElementById("removeEstadoForm");
		
			if(confirm("Voc? deseja realmente excluir este Estado?")){
				removeEstadoForm.submit();
			}
		}
		
		function irParaLista() {
			location.href = "http://localhost:8080/projetoweb/ListaEstado";
		}	
	</script>
	
	</head>
	<body>
		
		<div class="container mt-5">
		
			<h1 align="center">Cadastro de Estado</h1>
		
			<div class="input-group divForm ">
				<form:form method="POST" action="/projetoweb/addEstado" class="form">
					<form:hidden path="idEstado"/>
				
					Nome<form:input path="nome" required="true" maxlength="80" class="form-control mb-3"/> <form:errors path="nome" cssClass="error"/>
					Sigla<form:input path="sigla" required="true" maxlength="2" class="form-control mb-3 inpMn"/> <form:errors path="sigla" cssClass="error"/>
					C?digo Ibge<form:input path="codigoIbge" type="number" max="53" min="11" required="true" class="form-control mb-3 inpMn"/> <form:errors path="codigoIbge" cssClass="error"/>
					
					<div class="d-grid gap-2">
						<input type="submit" class="btn btn-primary btn-lg"/>
						<input type="button" class="btn btn-danger btn-lg " value="Excluir" onclick="excluirEstado();"/> 
						<input type="button" class="btn btn-outline-primary" value="Ir para lista" onclick="irParaLista()">
					</div>
					
				</form:form>
			</div>
			
			<form id="removeEstadoForm" action="RemoveEstado" method="post">
				<input type="hidden" name="idEstado" value="${command.idEstado}"/>
			</form>
	
		</div>
	</body>
</html>