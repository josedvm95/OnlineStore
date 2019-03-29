package daos;

import java.util.List;

import modelo.CategoriaUsuario;

public interface CategoriasUsuariosDAO {
	
	void registrarCategoria(CategoriaUsuario c);
	List<CategoriaUsuario> obtenerCategorias();

}
