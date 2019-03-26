package daos;

import java.util.List;

import modelo.Categoria;

public interface CategoriasDAO {
	
	void registrarCategoria(Categoria c);
	List<Categoria> obtenerCategorias();

}
