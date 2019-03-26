package servlets;

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

/**
 * Servlet implementation class ServletIdentificacionUsuario
 */
@WebServlet("/ServletIdentificacionUsuario")
public class ServletIdentificacionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("campoEmail");
		String pass = request.getParameter("campoPass");
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		int id = dao.obtenerIdUsuarioPorEmailYPass(email, pass);
		System.out.println("id: " + id);
		if(id > 0) {
			System.out.println("Usuario identificado correctamente");
			// Approvechamos y metemos la id de usuario en su sesión
			// Sesión es un espacio de memoria para cada usuario
			request.getSession().setAttribute("idUsuario", id);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/ServletZonaPrivada");
			rd.forward(request, response);
		} else {
			System.out.println("Email o pass incorrecto");
			request.setAttribute("errorLogin", "email o contraseña incorrectos");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		
	}

}
