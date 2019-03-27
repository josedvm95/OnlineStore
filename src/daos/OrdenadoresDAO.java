package daos;

import java.util.List;

import modelo.Ordenador;

public interface OrdenadoresDAO {
	
	int registrarOrdenador(Ordenador o);
	List<Ordenador> obtenerOrdenadores();
	void modificarOrdenador(Ordenador o);
	void borrarOrdenador(int id);
	Ordenador obtenerOrdenadorPorId(int id);
	List<Ordenador> obtenerOrdenadores(String palabra, int comienzo, int cuantos);
	int obtenerTotalOrdenadores();
	int obtenerTotalBusqueda(String palabra, int comienzo, int cuantos);

}
