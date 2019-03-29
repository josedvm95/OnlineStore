<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de usuarios</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Introduce los datos del nuevo usuario</div>
	<form action="ServletRegistroUsuarioAdmin" method="post"><br/>
		nombre:<input type="text" name="campoNombre"/><br/>
		email:<input type="email" name="campoEmail"/><br/>
		contraseña:<input type="password" name="campoPass"/><br/>
		categoría:
		<select name="campoIdCategoria">
			<c:forEach items="${categorias}" var="c">
					<option value="${c.id}">${c.nombre}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Registrar"/>
	
	</form>

</body>
</html>