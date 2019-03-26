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

import daos.UsuariosDAO;
import modelo.Usuario;

@WebServlet("/admin/ServletGuardarCambiosUsuario")
public class ServletGuardarCambiosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		String email = request.getParameter("campoEmail");
		String pass = request.getParameter("campoPass");
		String idStr = request.getParameter("campoId");
		int id = Integer.parseInt(idStr);
		
		Usuario nuevo = new Usuario(nombre, email, pass);
		nuevo.setId(id);

		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		
		dao.modificarUsuario(nuevo);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoUsuarios");
		rd.forward(request, response);

	}

}
