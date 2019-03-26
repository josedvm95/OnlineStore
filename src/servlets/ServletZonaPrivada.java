package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletZonaPrivada
 */
@WebServlet("/ServletZonaPrivada")
public class ServletZonaPrivada extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("idUsuario") != null) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/zonaPrivada.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("errorLogin", "Debes identificarte para entrar aquí");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

	}

}
