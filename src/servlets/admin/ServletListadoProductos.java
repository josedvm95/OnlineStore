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
		
		String campoBusqueda = request.getParameter("campoBusqueda");
		if(campoBusqueda == null) {
			campoBusqueda = "";
		}
		System.out.println("buscar ordenadores con la marca: " + campoBusqueda);
		request.setAttribute("campoBusqueda", campoBusqueda);
		
		// Paginación
		int comienzo = 0;
		int cuantos = 10;
		
		if(request.getParameter("comienzo") != null) {
			comienzo = Integer.parseInt(request.getParameter("comienzo"));
		}
		
		int siguiente = comienzo + 10;
		int anterior = comienzo - 10;
		int total = dao.obtenerTotalOrdenadores(campoBusqueda);

		List<Ordenador> ordenadores = dao.obtenerOrdenadores(comienzo, cuantos, campoBusqueda);
		
		request.setAttribute("ordenadores", ordenadores);
		request.setAttribute("anterior", anterior);
		request.setAttribute("siguiente", siguiente);
		request.setAttribute("total", total);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/listadoProductos.jsp");
		rd.forward(request, response);
	}

}
