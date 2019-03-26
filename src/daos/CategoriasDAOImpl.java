package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import modelo.Categoria;
import modelo.Servicio;

public class CategoriasDAOImpl implements CategoriasDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public DataSource getElDataSource() {
		return elDataSource;
	}
	
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_categorias");
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}
	
	@Override
	public void registrarCategoria(Categoria c) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("nombre", c.getNombre());
		valores.put("descripcion", c.getDescripcion());
		simpleInsert.execute(valores);
	}

	@Override
	public List<Categoria> obtenerCategorias() {
		String sql = ConstantesSQL.SQL_SELECCION_CATEGORIAS;
		List<Categoria> categorias = (List<Categoria>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Servicio.class));
		return categorias;
	}

}
