<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar categorías</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Introduce los datos de la nueva categoría</div>
	<form action="ServletRegistroCategoriaAdmin" method="post"><br/>
		nombre:<input type="text" name="campoNombre"/><br/>
		descripción:<input type="text" name="campoDescripcion"/><br/>
		<input type="submit" value="Registrar categoría"/>
	
	</form>

</body>
</html>