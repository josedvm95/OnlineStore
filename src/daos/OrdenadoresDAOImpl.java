package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import mappers.OrdenadoresMapper;
import modelo.Ordenador;

public class OrdenadoresDAOImpl implements OrdenadoresDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public DataSource getElDataSource() {
		return elDataSource;
	}
	
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_ordenadores");
		simpleInsert.usingGeneratedKeyColumns("id");
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}
	
	@Override
	public int registrarOrdenador(Ordenador o) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("marca", o.getMarca());
		valores.put("modelo", o.getModelo());
		valores.put("procesador", o.getProcesador());
		valores.put("grafica", o.getGrafica());
		valores.put("pulgadas", o.getPulgadas());
		valores.put("precio", o.getPrecio());
		valores.put("stock", o.getStock());
		int idGenerado = simpleInsert.executeAndReturnKey(valores).intValue();
		return idGenerado;
	}

	@Override
	public List<Ordenador> obtenerOrdenadores() {
		String sql = ConstantesSQL.SQL_SELECCION_ORDENADORES;
		List<Ordenador> ordenadores = (List<Ordenador>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Ordenador.class));
		return ordenadores;
	}

	@Override
	public void modificarOrdenador(Ordenador o) {
		String sql = ConstantesSQL.SQL_EDICION_ORDENADORES;
		jdbcTemplate.update(sql, o.getMarca(), o.getModelo(), o.getProcesador(), o.getGrafica(), o.getPulgadas(), o.getPrecio(), o.getStock(), o.getId());
	}

	@Override
	public void borrarOrdenador(int id) {
		String sql = ConstantesSQL.SQL_BORRADO_ORDENADORES;
		jdbcTemplate.update(sql, id);
		
	}

	@Override
	public Ordenador obtenerOrdenadorPorId(int id) {
		String valores[] = {String.valueOf(id)};
		Ordenador ordenador = (Ordenador) jdbcTemplate.queryForObject(ConstantesSQL.SQL_OBTENER_ORDENADOR_POR_ID, valores, new BeanPropertyRowMapper(Ordenador.class));
		return ordenador;
	}

	@Override
	public List<Ordenador> obtenerOrdenadores(int comienzo, int cuantos) {
		Integer[] valores = {comienzo, cuantos};
		List<Ordenador> ordenadores = jdbcTemplate.query(ConstantesSQL.SQL_SELECCION_ORDENADORES_INICIO_CUANTOS, valores, new BeanPropertyRowMapper(Ordenador.class));
		return ordenadores;
	}

	@Override
	public int obtenerTotalOrdenadores() {
		int total = jdbcTemplate.queryForInt(ConstantesSQL.SQL_TOTAL_ORDENADORES);
		return total;
	}

	@Override
	public int obtenerTotalOrdenadores(String busqueda) {
		int total = jdbcTemplate.queryForInt(ConstantesSQL.SQL_TOTAL_ORDENADORES_BUSQUEDA, "%" + busqueda + "%");
		return total;
	}

	@Override
	public List<Ordenador> obtenerOrdenadores(int comienzo, int cuantos, String busqueda) {
		Object[] valores = {"%" + busqueda + "%", comienzo, cuantos};
		List<Ordenador> ordenadores = jdbcTemplate.query(ConstantesSQL.SQL_SELECCION_ORDENADORES_INICIO_CUANTOS_BUSQUEDA, valores, new OrdenadoresMapper());
		return ordenadores;
	}

}
