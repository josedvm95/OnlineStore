<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de usuarios</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Listado de usuarios registrados de la tienda</div>

	<table>
		<tr style="font-weight:bold;">
			<td>Id</td>
			<td>Nombre</td>
			<td>Email</td>
			<td>Pass</td>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nombre}</td>
				<td>${usuario.email}</td>
				<td>${usuario.pass}</td>
				<td><img src="../imagenesUsuarios/${usuario.id}.jpg"></td>
				<td>
					<form action="ServletBorradoUsuario">
						<input type="hidden" name="campoId" value="${usuario.id}">
					    <input onclick="return confirm ('¿Estás seguro?')" type="submit" value="Borrar" />
					</form>
				</td>
				<td>
					<form action="ServletEdicionUsuario">
						<input type="hidden" name="id" value="${usuario.id}">
 					    <input type="submit" value="Editar" />
					</form>
				</td>
				
			</tr>
		</c:forEach>
	</table>


</body>
</html>