package serv;

import java.io.IOException;
import java.sql.Connection;

import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;
/**
 * Servlet implementation class Controller_Vol
 */
public class Controller_Vol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        Vol vols= new Vol();
	        Connect conn=new Connect();
	        Connection c=conn.Connex();
	        Vol[] listeVols = vols.get_ListeVols(c);
	        request.setAttribute("listeVol", listeVols);
	        request.getRequestDispatcher("/WEB-INF/Liste.jsp").forward(request, response);
	    }
}
