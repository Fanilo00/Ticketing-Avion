package serv;

import java.io.IOException;
import java.sql.Connection;
import vols.Reservation;
import avion.Avion;
import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;

public class Controller_Client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 Vol vols= new Vol();
	        Connect conn=new Connect();
	        Connection c=conn.Connex();
	        Vol[] listeVols = vols.get_Vols_Valide(c);
	        Avion[] avs=new Avion[listeVols.length];
	        Avion[] avs2=new Avion[listeVols.length];

	        Reservation[] res = new Reservation[listeVols.length];
	       
	        for (int i = 0; i < listeVols.length; i++) {
	            avs[i] = Avion.get_Avion_by_Id(c, listeVols[i].getId_avion());
	            
	            res[i] = Reservation.get_Reservations_byIdVol(c,listeVols[i].getId_Vol());
	            
	            if (res[i] != null) { 
	          
	                int[] somplace = Reservation.getSommePlacesAffaireEco(res);
	                int som_affaire = somplace[0];
	                int som_eco = somplace[1];
	                avs[i].setNb_placeaff(avs[i].getNb_placeaff() - som_affaire);
	                avs[i].setNb_placeeco(avs[i].getNb_placeeco() - som_eco);
	                
	            } 
	              
	               avs2[i] = new Avion(avs[i].getId_avion(), avs[i].getNb_placeaff(), avs[i].getNb_placeeco());
	            
	        }

	        request.setAttribute("avions", avs2);
	        request.setAttribute("listevol",listeVols); 
	        request.getRequestDispatcher("/WEB-INF/Client.jsp").forward(request, response);
	    }
}
