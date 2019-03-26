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

import daos.OrdenadoresDAO;

@WebServlet("/admin/ServletBorradoProducto")
public class ServletBorradoProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("campoId");
		int id = Integer.parseInt(idStr);

		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		OrdenadoresDAO dao = contenedor.getBean(OrdenadoresDAO.class);
		dao.borrarOrdenador(id);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoProductos");
		rd.forward(request, response);

	}

}
