package daos;

import java.util.List;

import modelo.Servicio;

public interface ServiciosDAO {
	
	void registrarServicio(Servicio s);
	List<Servicio> obtenerServicios();

}
