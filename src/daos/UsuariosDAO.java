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

	List<Usuario> obtenerUsuarios(int comienzo, int cuantos);

	int obtenerTotalUsuarios();

	List<Usuario> obtenerUsuarios(int comienzo, int cuantos, String busqueda);

	int obtenerTotalUsuarios(String busqueda);
	// Los tres métodos obtenerUsuarios deberían ir uno detrás de otro por claridad
	// Los dos método obtenerTotalUsuarios deberían ir juntos, al igual que
	// cualesquiera métodos que se llamen igual
}
