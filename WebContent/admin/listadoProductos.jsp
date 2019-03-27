<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de productos</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Listado de productos de la tienda</div>
	<div>Total: ${total}</div>
	
	<form action="ServletListadoProductos">
		Buscar por marca:  &nbsp;
		<input type="text" name="campoBusqueda"/>
		<input type="submit" value="Buscar" />
	</form>
	
	<div>
		<c:if test="${anterior >= 0}">
			<a href="ServletListadoProductos?comienzo=${anterior}">anterior</a> &nbsp;&nbsp;&nbsp;&nbsp;
		</c:if>
		<c:if test="${siguiente < total}">
			<a href="ServletListadoProductos?comienzo=${siguiente}">siguiente</a>
		</c:if>
	</div>

	<table>
		<tr style="font-weight:bold;">
			<td>Id</td>
			<td>Marca</td>
			<td>Modelo</td>
			<td>Procesador</td>
			<td>Gráfica</td>
			<td>Pulgadas</td>
			<td>Precio</td>
			<td>Stock</td>
		</tr>
		<c:forEach items="${ordenadores}" var="ordenador">
			<tr>
				<td>${ordenador.id}</td>
				<td>${ordenador.marca}</td>
				<td>${ordenador.modelo}</td>
				<td>${ordenador.procesador}</td>
				<td>${ordenador.grafica}</td>
				<td>${ordenador.pulgadas}</td>
				<td>${ordenador.precio}</td>
				<td>${ordenador.stock}</td>
				<td><img src="../imagenesOrdenadores/${ordenador.id}.jpg" height="32"></td>
				<td>
					<form action="ServletBorradoProducto">
						<input type="hidden" name="campoId" value="${ordenador.id}">
					    <input onclick="return confirm ('¿Estás seguro?')" type="submit" value="Borrar" />
					</form>
				</td>
				<td>
					<form action="ServletEdicionProducto">
						<input type="hidden" name="id" value="${ordenador.id}">
 					    <input type="submit" value="Editar" />
					</form>
				</td>

			</tr>
		</c:forEach>
	</table>

</body>
</html>