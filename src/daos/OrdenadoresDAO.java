package daos;

import java.util.List;

import modelo.Ordenador;

public interface OrdenadoresDAO {
	
	int registrarOrdenador(Ordenador o);
	List<Ordenador> obtenerOrdenadores();
	void modificarOrdenador(Ordenador o);
	void borrarOrdenador(int id);
	Ordenador obtenerOrdenadorPorId(int id);
	List<Ordenador> obtenerOrdenadores(int comienzo, int cuantos);
	List<Ordenador> obtenerOrdenadores(int comienzo, int cuantos, String busqueda);
	int obtenerTotalOrdenadores();
	int obtenerTotalOrdenadores(String busqueda);

}
