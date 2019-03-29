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
	
	<form action="ServletListadoUsuarios">
		Buscar por nombre:  &nbsp;
		<input type="text" value="${campoBusqueda}" name="campoBusqueda"/>
		<input type="submit" value="Buscar" />
	</form>
	
	<div>Total de resultados: ${total}</div>
	
	<div>
		<c:choose>
			<c:when test="${anterior >= 0}">
				<a href="ServletListadoUsuarios?comienzo=${anterior}&campoBusqueda=${campoBusqueda}">anterior</a> &nbsp;&nbsp;&nbsp;&nbsp;
			</c:when>
			<c:otherwise>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</c:otherwise>
		</c:choose>
		<c:if test="${siguiente < total}">
			<a href="ServletListadoUsuarios?comienzo=${siguiente}&campoBusqueda=${campoBusqueda}">siguiente</a>
		</c:if>
	</div>

	<table>
		<tr style="font-weight:bold;">
			<th>Id</th>
			<th>Nombre</th>
			<th>Email</th>
			<th>Pass</th>
			<th>Categoría</th>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>${usuario.id}</td>
				<td>${usuario.nombre}</td>
				<td>${usuario.email}</td>
				<td>${usuario.pass}</td>
				<td>${usuario.categoriaUsuario.nombre}</td>
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