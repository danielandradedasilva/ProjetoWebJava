<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Cadastro Estado</title>
	<style type="text/css">
		.error{color: red}
	</style>
	
	<script type="text/javascript">
		
		function excluirEstado() {
			const removeEstadoForm = document.getElementById("removeEstadoForm");
		
			if(confirm("Voc� deseja realmente excluir este Estado?")){
				removeEstadoForm.submit();
			}
		}
		
		function irParaLista() {
			location.href = "http://localhost:8080/projetoweb/ListaEstado";
		}
		
	</script>
	
	</head>
	<body>
		
		<h1>Cadastro Estado</h1>
	
		<form:form method="POST" action="/projetoweb/addEstado">
			<form:hidden path="idEstado"/>
		
			Nome: <form:input path="nome" required="true" maxlength="80"/> <form:errors path="nome" cssClass="error"/> <br>
			Sigla: <form:input path="sigla" required="true" maxlength="2"/> <form:errors path="sigla" cssClass="error"/> <br>
			C�digo Ibge: <form:input path="codigoIbge" type="number" max="53" min="11" required="true"/> <form:errors path="codigoIbge" cssClass="error"/> <br>
			
			<input type="submit"/>
			<input type="button" value="Excluir" onclick="excluirEstado();"/>
			<input type="button" value="Ir para lista" onclick="irParaLista()">
		</form:form>
		
		<form id="removeEstadoForm" action="RemoveEstado" method="post">
			<input type="hidden" name="idEstado" value="${command.idEstado}"/>
		</form>
	
	</body>
</html>