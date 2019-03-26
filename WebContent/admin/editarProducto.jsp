<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar productos</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Edita los datos del producto</div>
	<form action="ServletGuardarCambiosProducto" method="post"><br/>
	    <input type="hidden" name="campoId" value="${ordenador.id}"/>
		marca:<input type="text" name="campoMarca" value="${ordenador.marca}"/><br/>
		modelo:<input type="text" name="campoModelo" value="${ordenador.modelo}"/><br/>
		procesador:<input type="text" name="campoProcesador" value="${ordenador.procesador}"/><br/>
		gráfica:<input type="text" name="campoGrafica" value="${ordenador.grafica}"/><br/>
		pulgadas:<input type="number" step="0.1" name="campoPulgadas" value="${ordenador.pulgadas}"/><br/>
		precio:<input type="number" step="0.01" name="campoPrecio" value="${ordenador.precio}"/><br/>
		stock:<input type="number" name="campoStock" value="${ordenador.stock}"/><br/>
		<input type="submit" value="Guardar cambios"/>
	
	</form>

</body>
</html>