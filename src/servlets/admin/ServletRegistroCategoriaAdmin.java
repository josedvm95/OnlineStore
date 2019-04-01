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

import daos.CategoriasOrdenadoresDAO;
import modelo.CategoriaOrdenador;

@WebServlet("/admin/ServletRegistroCategoriaAdmin")
public class ServletRegistroCategoriaAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("campoNombre");
		
		String descripcion = request.getParameter("campoDescripcion");
		
		CategoriaOrdenador nueva = new CategoriaOrdenador(nombre, descripcion);
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		CategoriasOrdenadoresDAO dao = contenedor.getBean(CategoriasOrdenadoresDAO.class);
		dao.registrarCategoria(nueva);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoCategorias");
		rd.forward(request, response);
		
		
	}

}
