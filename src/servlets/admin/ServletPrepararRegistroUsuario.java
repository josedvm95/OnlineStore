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

import daos.CategoriasUsuariosDAO;
import modelo.CategoriaUsuario;

@WebServlet("/admin/ServletPrepararRegistroUsuario")
public class ServletPrepararRegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Este servlet va a sacar las categorias de la base de datos para que
		// registrarUsuario.jsp las pueda mostrar en un desplegable
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		CategoriasUsuariosDAO dao = contenedor.getBean(CategoriasUsuariosDAO.class);
		List<CategoriaUsuario> categorias = dao.obtenerCategorias();
		request.setAttribute("categorias", categorias);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/registrarUsuario.jsp");
		rd.forward(request, response);
		
	}

}
