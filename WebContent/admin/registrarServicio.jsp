<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar servicios</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Introduce los datos del nuevo servicio</div>
	<form action="ServletRegistroServicioAdmin" method="post"><br/>
		nombre:<input type="text" name="campoNombre"/><br/>
		descripción:<input type="text" name="campoDescripcion"/><br/>
		precio:<input type="number" step="0.01" name="campoPrecio"/><br/>
		<input type="submit" value="Registrar servicio"/>
	
	</form>

</body>
</html>