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

import daos.CategoriasOrdenadoresDAO;
import modelo.CategoriaOrdenador;

@WebServlet("/admin/ServletListadoCategorias")
public class ServletListadoCategorias extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		CategoriasOrdenadoresDAO dao = contenedor.getBean(CategoriasOrdenadoresDAO.class);

		List<CategoriaOrdenador> categorias = dao.obtenerCategorias();
		request.setAttribute("categorias", categorias);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoCategorias.jsp");
		rd.forward(request, response);
	}

}
