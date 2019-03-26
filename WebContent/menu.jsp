<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
	<a href="index.jsp">INICIO</a>
	<c:if test="${sessionScope.idUsuario == null}">
		<a href="login.jsp">Identificarme</a>
		<a href="registro.jsp">Registrarme</a>
	</c:if>
	<a href="ServletZonaPrivada">Zona Privada</a>
	<c:if test="${sessionScope.idUsuario != null}">
		<a href="ServletDesconexion">Log Out</a>
	</c:if>
</div>