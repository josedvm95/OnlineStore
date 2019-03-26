<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar usuarios</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Edita los datos del usuario</div>
	<form action="ServletGuardarCambiosUsuario" method="post"><br/>
	    <input type="hidden" name="campoId" value="${usuario.id}"/>
		nombre:<input type="text" name="campoNombre" value="${usuario.nombre}"/><br/>
		email:<input type="text" name="campoEmail" value="${usuario.email}"/><br/>
		pass:<input type="text" name="campoPass" value="${usuario.pass}"/><br/>
		<input type="submit" value="Guardar cambios"/>
	
	</form>

</body>
</html>