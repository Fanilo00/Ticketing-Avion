package serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;

import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;

public class Controller_Insert_Vol {
	private static final long serialVersionUID = 1L;
    
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idAvion = Integer.parseInt(request.getParameter("id_avion"));
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        Timestamp dateVol = Timestamp.valueOf(request.getParameter("date_vol"));
        int prix = Integer.parseInt(request.getParameter("prix"));
        
        Vol vol = new Vol();
        vol.setId_avion(idAvion);
        vol.setSource(source);
        vol.setDestination(destination);
        vol.setDate_vol(dateVol);
        vol.setPrix(prix);
        
        Connect conn = new Connect();
        Connection c = conn.Connex();
        vol.insert_vol(c);

        request.getRequestDispatcher("insert_vol.jsp").forward(request, response);
    }

}
