<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de categorías</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Listado de categorías disponibles</div>

	<table>
		<tr style="font-weight:bold;">
			<td>Nombre</td>
			<td>Descripción</td>
		</tr>
		<c:forEach items="${categorias}" var="categoria">
			<tr>
				<td>${categoria.nombre}</td>
				<td>${categoria.descripcion}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>