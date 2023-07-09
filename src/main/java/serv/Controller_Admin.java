package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;

import java.io.IOException;
import java.sql.Connection;

import connex.Connect;


public class Controller_Admin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -304271601828994101L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	        Vol vols= new Vol();
	        Connect conn=new Connect();
	        Connection c=conn.Connex();
	        Vol[] listeVols = vols.get_ListeVols_invalide(c);
	        request.setAttribute("listeVol", listeVols);
	        request.getRequestDispatcher("/WEB-INF/Administration.jsp").forward(request, response);
	    }
}



