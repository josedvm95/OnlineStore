package constantes;

public class ConstantesSQL {
	
	public final static String SQL_SELECCION_ID_POR_EMAIL_PASS = "SELECT id FROM tabla_usuarios WHERE email=? AND pass=?;";
	public final static String SQL_SELECCION_USUARIOS = "SELECT * FROM tabla_usuarios ORDER BY id DESC;";
	public final static String SQL_BORRADO_USUARIOS = "DELETE FROM tabla_usuarios WHERE id=?;";
	public final static String SQL_EDICION_USUARIOS = "UPDATE tabla_usuarios SET nombre=?, email=?, pass=? WHERE id=?;";
	public final static String SQL_OBTENER_USUARIO_POR_ID = "SELECT * FROM tabla_usuarios WHERE id=?;";
	public final static String SQL_SELECCION_USUARIOS_INICIO_CUANTOS = "SELECT * FROM tabla_usuarios order by id desc limit ?,?;";
	public final static String SQL_TOTAL_USUARIOS = "SELECT COUNT(*) FROM tabla_usuarios;";
	public final static String SQL_SELECCION_ORDENADORES = "SELECT * FROM tabla_ordenadores ORDER BY id DESC;";
	public final static String SQL_BORRADO_ORDENADORES = "DELETE FROM tabla_ordenadores WHERE id=?;";
	public final static String SQL_EDICION_ORDENADORES = "UPDATE tabla_ordenadores SET marca=?, modelo=?, procesador=?, grafica=?, pulgadas=?, precio=?, stock=? WHERE id=?;";
	public final static String SQL_OBTENER_ORDENADOR_POR_ID = "SELECT * FROM tabla_ordenadores WHERE id=?;";
	public final static String SQL_SELECCION_SERVICIOS = "SELECT * FROM tabla_servicios ORDER BY id DESC;";
	public final static String SQL_SELECCION_CATEGORIAS = "SELECT * FROM tabla_categorias ORDER BY id DESC;";

}
