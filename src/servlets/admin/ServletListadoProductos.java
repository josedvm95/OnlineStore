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

import daos.OrdenadoresDAO;
import modelo.Ordenador;

@WebServlet("/admin/ServletListadoProductos")
public class ServletListadoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		OrdenadoresDAO dao = contenedor.getBean(OrdenadoresDAO.class);

		List<Ordenador> ordenadores = dao.obtenerOrdenadores();
		request.setAttribute("ordenadores", ordenadores);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoProductos.jsp");
		rd.forward(request, response);
	}

}
