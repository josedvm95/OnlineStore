package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import modelo.CategoriaOrdenador;

public class CategoriasOrdenadoresDAOImpl implements CategoriasOrdenadoresDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public DataSource getElDataSource() {
		return elDataSource;
	}
	
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_categorias_ordenador");
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}
	
	@Override
	public void registrarCategoria(CategoriaOrdenador c) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("nombre", c.getNombre());
		valores.put("descripcion", c.getDescripcion());
		simpleInsert.execute(valores);
	}

	@Override
	public List<CategoriaOrdenador> obtenerCategorias() {
		String sql = ConstantesSQL.SQL_SELECCION_CATEGORIAS_ORDENADOR;
		List<CategoriaOrdenador> categorias = (List<CategoriaOrdenador>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(CategoriaOrdenador.class));
		return categorias;
	}

}
