package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import modelo.CategoriaUsuario;
import modelo.Usuario;

public class UsuariosMapper implements RowMapper<Usuario> {

	@Override
	public Usuario mapRow(ResultSet rs, int numeroFila) throws SQLException {
		Usuario u = new Usuario();
		u.setNombre(rs.getString("nombre"));
		u.setEmail(rs.getString("email"));
		u.setPass(rs.getString("pass"));
		u.setId(rs.getInt("id"));
		CategoriaUsuario cu = new CategoriaUsuario();
		cu.setNombre(rs.getString("nombreCategoria"));
		u.setCategoriaUsuario(cu);
		
		return u;
	}


}
