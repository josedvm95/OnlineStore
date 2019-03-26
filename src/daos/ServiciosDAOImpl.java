package daos;

import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import constantes.ConstantesSQL;
import modelo.Servicio;

public class ServiciosDAOImpl implements ServiciosDAO {
	
	private DataSource elDataSource;
	private SimpleJdbcInsert simpleInsert;
	private JdbcTemplate jdbcTemplate;

	public DataSource getElDataSource() {
		return elDataSource;
	}
	
	public void setElDataSource(DataSource elDataSource) {
		this.elDataSource = elDataSource;
		simpleInsert = new SimpleJdbcInsert(elDataSource);
		simpleInsert.setTableName("tabla_servicios");
		jdbcTemplate = new JdbcTemplate(elDataSource);
		
	}
	
	@Override
	public void registrarServicio(Servicio s) {
		HashMap<String, Object> valores = new HashMap<String, Object>();
		valores.put("nombre", s.getNombre());
		valores.put("descripcion", s.getDescripcion());
		valores.put("precio", s.getPrecio());
		simpleInsert.execute(valores);
	}

	@Override
	public List<Servicio> obtenerServicios() {
		String sql = ConstantesSQL.SQL_SELECCION_SERVICIOS;
		List<Servicio> servicios = (List<Servicio>) jdbcTemplate.query(sql, new BeanPropertyRowMapper(Servicio.class));
		return servicios;
	}

}
