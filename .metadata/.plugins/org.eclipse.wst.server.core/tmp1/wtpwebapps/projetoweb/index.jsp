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
	.card{
		margin-top: 150px;
	}
	h1{
		margin-top: 80px;
	}
	body{
	 background-color: #fff;
	}
</style>
</head>
<body>

	<div class="container">
		<h1 align="center">Fa?a o cadastro dos Estados</h1>
		
		<div class="card text-center">
			<div class="card-header">
			   Vamos l?!
			</div>
		 <div class="card-body">
		    <h5 class="card-title"> Voc? pode cadastrar, quantos estados quiser!</h5>
		    <p class="card-text">No cadastro voc? dever? informar, o nome, a sigla e o c?digo Ibge.</p>
		    <a href="http://localhost:8080/projetoweb/ListaEstado" class="btn btn-primary">Lista de Cadastro</a>
		 </div>	  
	</div>
		
		<div class="row">
			<div class="col"></div>
		</div>
	
	</div>

</body>
</html>