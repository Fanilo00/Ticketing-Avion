package serv;

import java.io.IOException;
import java.sql.Connection;

import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;
public class Controller_Emp extends HttpServlet {
	
	private static final long serialVersionUID = 3268825695494181605L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   Vol vols= new Vol();
	        Connect conn=new Connect();
	        Connection c=conn.Connex();
	        Vol[] all = vols.get_All_ListeVols(c);
	        request.setAttribute("allvol", all); 
	            request.getRequestDispatcher("/WEB-INF/Employer.jsp").forward(request, response);
	        }
	    
}

