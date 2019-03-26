package servlets.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.UsuariosDAO;
import modelo.Usuario;

@WebServlet("/admin/ServletListadoUsuarios")
public class ServletListadoUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger de base de datos con un DAO todos los usuario para que sean listados
		// en listadoUsuarios.jsp

		// Así recojo el contenedor y le pido la bean del dao que necesito para pedir
		// los usuarios en base de datos
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		
		List<Usuario> usuarios = dao.obtenerUsuarios();
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoUsuarios.jsp");
		rd.forward(request, response);
	}

}
