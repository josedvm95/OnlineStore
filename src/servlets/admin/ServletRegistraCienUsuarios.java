package servlets.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.UsuariosDAO;
import modelo.Usuario;

@WebServlet("/admin/ServletRegistraCienUsuarios")
public class ServletRegistraCienUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Servlet que pide el dao de usuarios a Spring para registrar 100 usuarios y
		// así poder hacer pruebas con el tema de paginación
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		for (int i = 0; i < 100; i++) {
			Usuario u = new Usuario("usuario" + i, "usuario" + i + "@gmail.com", "1234");
			dao.registrarUsuario(u);
			System.out.println("registrado: " + u.toString());
		}
		System.out.println("100 usuarios registrados");
		
	}// end service

} // end class
