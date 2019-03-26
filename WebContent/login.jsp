<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	
	<jsp:include page="menu.jsp"/>
	<div>Introduce tu email y tu contraseña</div>
	
	<div style="color: red">${errorLogin}</div>
	
	<form action="ServletIdentificacionUsuario" method="post">
		email: <input type="email" name="campoEmail"/><br/>
		contraseña: <input type="password" name="campoPass"/><br/>
		<input type="submit" value="Registrarme"/>
	</form>
	

</body>
</html>