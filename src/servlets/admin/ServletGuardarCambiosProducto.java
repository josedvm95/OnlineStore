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
import modelo.Ordenador;

@WebServlet("/admin/ServletGuardarCambiosProducto")
public class ServletGuardarCambiosProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String marca = request.getParameter("campoMarca");
		String modelo = request.getParameter("campoModelo");
		String procesador = request.getParameter("campoProcesador");
		String grafica = request.getParameter("campoGrafica");
		String pulgadasStr = request.getParameter("campoPulgadas");
		String precioStr = request.getParameter("campoPrecio");
		String stockStr = request.getParameter("campoStock");
		String idStr = request.getParameter("campoId");
		precioStr = precioStr.replaceAll(",", ".");
		pulgadasStr = pulgadasStr.replaceAll(",", ".");
		double precio = Double.parseDouble(precioStr);
		double pulgadas = Double.parseDouble(pulgadasStr);
		int stock = Integer.parseInt(stockStr);
		int id = Integer.parseInt(idStr);
		Ordenador nuevo = new Ordenador(marca, modelo, procesador, grafica, pulgadas, precio, stock);
		nuevo.setId(id);

		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		OrdenadoresDAO dao = contenedor.getBean(OrdenadoresDAO.class);
		
		dao.modificarOrdenador(nuevo);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoProductos");
		rd.forward(request, response);

	}

}
