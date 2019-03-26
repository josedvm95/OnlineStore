package servlets.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import daos.OrdenadoresDAO;
import modelo.Ordenador;

@WebServlet("/admin/ServletRegistroProductoAdmin")
@MultipartConfig
public class ServletRegistroProductoAdmin extends HttpServlet {
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
		precioStr = precioStr.replaceAll(",", ".");
		pulgadasStr = pulgadasStr.replaceAll(",", ".");
		double precio = Double.parseDouble(precioStr);
		double pulgadas = Double.parseDouble(pulgadasStr);
		int stock = Integer.parseInt(stockStr);
		Ordenador nuevo = new Ordenador(marca, modelo, procesador, grafica, pulgadas, precio, stock);

		WebApplicationContext contenedor = ContextLoader.getCurrentWebApplicationContext();
		OrdenadoresDAO dao = contenedor.getBean(OrdenadoresDAO.class);
		int idGenerado = dao.registrarOrdenador(nuevo);

		// Procesar la subida de archivo
		String rutaArchivo = getServletContext().getRealPath("") + File.separator + "imagenesOrdenadores";
		File carpeta = new File(rutaArchivo);
		if (!carpeta.exists()) {
			carpeta.mkdir();
		}
		Part campoImagen = request.getPart("campoImagen");
		campoImagen.write(rutaArchivo + File.separator + idGenerado + ".jpg");

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/admin/ServletListadoProductos");
		rd.forward(request, response);

	}

}
