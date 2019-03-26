<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registrar productos</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	<div>Introduce los datos del nuevo producto</div>
	<form action="ServletRegistroProductoAdmin" method="post" enctype="multipart/form-data"><br/>
		marca:<input type="text" name="campoMarca"/><br/>
		modelo:<input type="text" name="campoModelo"/><br/>
		procesador:<input type="text" name="campoProcesador"/><br/>
		gráfica:<input type="text" name="campoGrafica"/><br/>
		pulgadas:<input type="number" step="0.1" name="campoPulgadas"/><br/>
		precio:<input type="number" step="0.01" name="campoPrecio"/><br/>
		stock:<input type="number" name="campoStock"/><br/>
		imagen:<input type="file" name="campoImagen"/><br/>
		<input type="submit" value="Registrar producto"/>
	
	</form>

</body>
</html>