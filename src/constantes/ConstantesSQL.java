package constantes;

public class ConstantesSQL {
	
	public final static String SQL_SELECCION_ID_POR_EMAIL_PASS = "SELECT id FROM tabla_usuarios WHERE email=? AND pass=?;";
	public final static String SQL_SELECCION_USUARIOS = "SELECT * FROM tabla_usuarios ORDER BY id DESC;";
	public final static String SQL_BORRADO_USUARIOS = "DELETE FROM tabla_usuarios WHERE id=?;";
	public final static String SQL_EDICION_USUARIOS = "UPDATE tabla_usuarios SET nombre=?, email=?, pass=? WHERE id=?;";
	public final static String SQL_OBTENER_USUARIO_POR_ID = "SELECT * FROM tabla_usuarios WHERE id=?;";
	public final static String SQL_SELECCION_USUARIOS_INICIO_CUANTOS = "SELECT * FROM tabla_usuarios order by id desc limit ?,?;";
	public final static String SQL_TOTAL_USUARIOS = "SELECT COUNT(*) FROM tabla_usuarios;";
	public final static String SQL_SELECCION_USUARIOS_INICIO_CUANTOS_BUSQUEDA = "SELECT tu.*, tcu.nombre AS nombreCategoria FROM tabla_usuarios AS tu, tabla_categorias_usuario AS tcu WHERE tu.idCategoria = tcu.id AND tu.nombre LIKE ? ORDER BY tu.id desc limit ?,?;";
	public final static String SQL_TOTAL_USUARIOS_BUSQUEDA = "SELECT COUNT(*) FROM tabla_usuarios WHERE nombre LIKE ?;";
	
	public final static String SQL_SELECCION_ORDENADORES = "SELECT * FROM tabla_ordenadores ORDER BY id DESC;";
	public final static String SQL_BORRADO_ORDENADORES = "DELETE FROM tabla_ordenadores WHERE id=?;";
	public final static String SQL_EDICION_ORDENADORES = "UPDATE tabla_ordenadores SET marca=?, modelo=?, procesador=?, grafica=?, pulgadas=?, precio=?, stock=? WHERE id=?;";
	public final static String SQL_OBTENER_ORDENADOR_POR_ID = "SELECT * FROM tabla_ordenadores WHERE id=?;";
	public final static String SQL_SELECCION_ORDENADORES_INICIO_CUANTOS = "SELECT * FROM tabla_ordenadores order by id desc limit ?,?;";
	public final static String SQL_SELECCION_ORDENADORES_INICIO_CUANTOS_BUSQUEDA = "SELECT tor.*, tco.nombre AS nombreCategoria FROM tabla_ordenadores AS tor, tabla_categorias_ordenador AS tco WHERE tor.idCategoria = tco.id AND tor.marca LIKE ? ORDER BY id desc limit ?,?;";
	public final static String SQL_TOTAL_ORDENADORES = "SELECT COUNT(*) FROM tabla_ordenadores;";
	public final static String SQL_TOTAL_ORDENADORES_BUSQUEDA = "SELECT COUNT(*) FROM tabla_ordenadores WHERE marca LIKE ?;";
	
	public final static String SQL_SELECCION_SERVICIOS = "SELECT * FROM tabla_servicios ORDER BY id DESC;";
	public final static String SQL_SELECCION_CATEGORIAS_ORDENADOR = "SELECT * FROM tabla_categorias_ordenador ORDER BY id DESC;";
	public final static String SQL_SELECCION_CATEGORIAS_USUARIO = "SELECT * FROM tabla_categorias_usuario ORDER BY id DESC;";
	
}
