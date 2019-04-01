package daos;

import java.util.List;

import modelo.CategoriaOrdenador;

public interface CategoriasOrdenadoresDAO {
	
	void registrarCategoria(CategoriaOrdenador c);
	List<CategoriaOrdenador> obtenerCategorias();

}
