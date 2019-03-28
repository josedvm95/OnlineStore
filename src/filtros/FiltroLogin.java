package filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FiltroLogin implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// Este es el código que se va a ejecutar cuando el filtro actué. El req y
		// el res que recibe nos los da del tipo que estoy acostumbrado a usar en
		// los servlet, por eso lo primero que hago es un casting al tipo request y
		// response que estamos acostumbrados a usar en un servlet
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if(request.getParameter("passAdmin") != null && request.getParameter("passAdmin").equals("1234")) {
			// Se ha introducido la contraseña correcta en el formulario de login de admin
			request.getSession().setAttribute("admin", "ok");
		}
		
		// Voy a entender que el administrador está identificado si en la sesión está
		// metido un string llamado admin y que valga ok
		if(request.getSession().getAttribute("admin") != null && request.getSession().getAttribute("admin").equals("ok")) {
			// Esto es que el admin está identificado
			chain.doFilter(req, res);
			
		} else {
			// Esto es que el admin aún no se ha identificado
			RequestDispatcher rd = request.getRequestDispatcher("/admin/login.jsp");
			rd.forward(request, response);
		}

	}

}
