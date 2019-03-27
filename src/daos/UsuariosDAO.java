package daos;

import java.util.List;

import modelo.Usuario;

public interface UsuariosDAO {
	
	int registrarUsuario(Usuario u);
	List<Usuario> obtenerUsuarios();
	int obtenerIdUsuarioPorEmailYPass(String email, String pass);
	void borrarUsuario(int id);
	Usuario obtenerUsuarioPorId(int id);
	void modificarUsuario(Usuario u);
	List<Usuario> obtenerUsuarios (int comienzo, int cuantos);
	int obtenerTotalUsuarios();
}
