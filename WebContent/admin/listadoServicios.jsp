<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de servicios</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Listado de servicios que ofrece la tienda</div>

	<table>
		<tr style="font-weight:bold;">
			<td>Nombre</td>
			<td>Descripción</td>
			<td>Precio</td>
		</tr>
		<c:forEach items="${servicios}" var="servicio">
			<tr>
				<td>${servicio.nombre}</td>
				<td>${servicio.descripcion}</td>
				<td>${servicio.precio}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>