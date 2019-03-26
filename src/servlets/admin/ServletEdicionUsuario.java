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

@WebServlet("/admin/ServletEdicionUsuario")
public class ServletEdicionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recoger el id y sacar todos los datos del usuario para presentarlos en un formulario donde puedan ser editados
		String idPulsado = request.getParameter("id");
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		UsuariosDAO dao = contenedor.getBean(UsuariosDAO.class);
		
		Usuario usuario = dao.obtenerUsuarioPorId(Integer.parseInt(idPulsado));
		// Ya tengo el ordenador a editar
		request.setAttribute("usuario", usuario);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/editarUsuario.jsp");
		rd.forward(request, response);

	}

}
