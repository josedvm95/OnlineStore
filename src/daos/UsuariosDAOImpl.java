package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import mappers.UsuariosMapper;
import modelo.Usuario;

public class UsuariosDAOImpl implements UsuariosDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	
	public DataSource getElDataSource() {
		return elDataSource;
	}

	// Para que este DAO funcione tiene que recibir un data source, cuando llegue preparo el simpleInsert
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_usuarios");
		simpleInsert.usingGeneratedKeyColumns("id"); // Para que el SimpleInsert sepa cuál es la clave primaria
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}

	@Override
	public int registrarUsuario(Usuario u) {
		// Necesitamos saber el id que se ha generado
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("nombre", u.getNombre());
		valores.put("email", u.getEmail());
		valores.put("pass", u.getPass());
		valores.put("idCategoria", u.getIdCategoria());
		
		// Esto era para cuando no nos importaba el id generado
		//simpleInsert.execute(valores);
		
		int idGenerado = simpleInsert.executeAndReturnKey(valores).intValue();
		return idGenerado;
		
	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		String sql = ConstantesSQL.SQL_SELECCION_USUARIOS;
		List<Usuario> usuarios = (List<Usuario>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Usuario.class));
		return usuarios;
	}

	@Override
	public int obtenerIdUsuarioPorEmailYPass(String email, String pass) {
		int id = -1;
		String sql = ConstantesSQL.SQL_SELECCION_ID_POR_EMAIL_PASS;
		try {
			id = jdbcTemplate.queryForInt(sql, new Object[] {email, pass});
		} catch (Exception e) {
			System.out.println("Error al obtener id de usuario");
			System.out.println(e.getMessage());
		}
		
		return id;
	}

	@Override
	public void borrarUsuario(int id) {
		String sql = ConstantesSQL.SQL_BORRADO_USUARIOS;
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Usuario obtenerUsuarioPorId(int id) {
		String valores[] = {String.valueOf(id)};
		Usuario usuario = (Usuario) jdbcTemplate.queryForObject(ConstantesSQL.SQL_OBTENER_USUARIO_POR_ID, valores, new BeanPropertyRowMapper(Usuario.class));
		return usuario;
	}

	@Override
	public void modificarUsuario(Usuario u) {
		String sql = ConstantesSQL.SQL_EDICION_USUARIOS;
		jdbcTemplate.update(sql, u.getNombre(), u.getEmail(), u.getPass(), u.getId());
		
	}

	@Override
	public List<Usuario> obtenerUsuarios(int comienzo, int cuantos) {
		Integer[] valores = {comienzo, cuantos};
		List<Usuario> usuarios = jdbcTemplate.query(ConstantesSQL.SQL_SELECCION_USUARIOS_INICIO_CUANTOS, valores, new BeanPropertyRowMapper(Usuario.class));
		return usuarios;
	}

	@Override
	public int obtenerTotalUsuarios() {
		int total = jdbcTemplate.queryForInt(ConstantesSQL.SQL_TOTAL_USUARIOS);
		return total;
	}

	@Override
	public List<Usuario> obtenerUsuarios(int comienzo, int cuantos, String busqueda) {
		Object[] valores = {"%" + busqueda + "%", comienzo, cuantos};
		// UsuariosMapper es una clase donde decimo cómo formar un usuario de cada fila resultado de la base de datos
		List<Usuario> usuarios = jdbcTemplate.query(ConstantesSQL.SQL_SELECCION_USUARIOS_INICIO_CUANTOS_BUSQUEDA, valores, new UsuariosMapper());
		return usuarios;
	}

	@Override
	public int obtenerTotalUsuarios(String busqueda) {
		int total = jdbcTemplate.queryForInt(ConstantesSQL.SQL_TOTAL_USUARIOS_BUSQUEDA, "%" + busqueda + "%");
		return total;
	}

}
