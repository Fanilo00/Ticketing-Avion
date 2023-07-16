package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;
import java.io.IOException;
import java.sql.Connection;
import avion.Avion;
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
	        Vol[] encours = vols.get_Vols_Encours(c);
	        Avion[] avs=new Avion[encours.length];
        	for(int i=0;i<encours.length;i++)
        	{
        		avs[i]=Avion.get_Avion_by_Id(c,encours[i].getId_avion());
        	}
        request.setAttribute("avions", avs);
	        request.setAttribute("Encours",encours);         
		            request.getRequestDispatcher("/WEB-INF/Administration.jsp").forward(request, response);
		        }
	}




