package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.CategoriaOrdenador;
import modelo.Ordenador;

public class OrdenadoresMapper implements RowMapper<Ordenador> {

	@Override
	public Ordenador mapRow(ResultSet rs, int numeroFila) throws SQLException {
		Ordenador o = new Ordenador();
		o.setMarca(rs.getString("marca"));
		o.setModelo(rs.getString("modelo"));
		o.setProcesador(rs.getString("procesador"));
		o.setGrafica(rs.getString("grafica"));
		o.setPulgadas(Double.parseDouble(rs.getString("pulgadas")));
		o.setPrecio(Double.parseDouble(rs.getString("precio")));
		o.setStock(Integer.parseInt(rs.getString("stock")));
		o.setId(Integer.parseInt(rs.getString("id")));
		CategoriaOrdenador co = new CategoriaOrdenador();
		co.setNombre(rs.getString("nombreCategoria"));
		o.setCategoriaOrdenador(co);
		return o;
	}

}
