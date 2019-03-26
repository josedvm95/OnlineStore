package servlets.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.ServiciosDAO;
import modelo.Servicio;

@WebServlet("/admin/ServletRegistroServicioAdmin")
public class ServletRegistroServicioAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String descripcion = request.getParameter("campoDescripcion");
		String precioStr = request.getParameter("campoPrecio");
		precioStr = precioStr.replaceAll(",", ".");
		double precio = Double.parseDouble(precioStr);
		
		Servicio nuevo = new Servicio(nombre, descripcion, precio);
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		ServiciosDAO dao = contenedor.getBean(ServiciosDAO.class);
		dao.registrarServicio(nuevo);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoServicios");
		rd.forward(request, response);
		
		
	}

}
