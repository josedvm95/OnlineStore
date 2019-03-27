package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.OrdenadoresDAO;
import daos.UsuariosDAO;
import modelo.Ordenador;
import modelo.Usuario;

@WebServlet("/admin/ServletRegistraCienProductos")
public class ServletRegistraCienProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet que pide el dao de ordenadores a Spring para registrar 100 ordenadores y
		// así poder hacer pruebas con el tema de paginación
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		OrdenadoresDAO dao = contenedor.getBean(OrdenadoresDAO.class);
		for (int i = 0; i < 100; i++) {
			Ordenador o = new Ordenador("Samsung", "modelo" + i, "intel i7", "GTX1050", 14, 1499, 10);
			dao.registrarOrdenador(o);
			System.out.println("registrado: " + o.toString());
		}
		System.out.println("100 ordenadores registrados");
		
	}// end service

} // end class
