<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>

	<jsp:include page="menu.jsp"/>
	<div>Introduce los datos del nuevo usuarioe:</div>
	<form action="ServletRegistroUsuario" method="post"><br/>
		nombre:<input type="text" name="campoNombre"/><br/>
		email:<input type="email" name="campoEmail"/><br/>
		contraseña:<input type="password" name="campoPass"/><br/>
		<input type="submit" value="Registrarme"/>
	
	</form>

</body>
</html>