package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import modelo.CategoriaUsuario;

public class CategoriasUsuariosDAOImpl implements CategoriasUsuariosDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public DataSource getElDataSource() {
		return elDataSource;
	}
	
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_categorias_usuario");
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}
	
	@Override
	public void registrarCategoria(CategoriaUsuario c) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("nombre", c.getNombre());
		valores.put("descripcion", c.getDescripcion());
		simpleInsert.execute(valores);
	}

	@Override
	public List<CategoriaUsuario> obtenerCategorias() {
		String sql = ConstantesSQL.SQL_SELECCION_CATEGORIAS_USUARIO;
		List<CategoriaUsuario> categorias = (List<CategoriaUsuario>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(CategoriaUsuario.class));
		return categorias;
	}

}
