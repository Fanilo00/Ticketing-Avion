package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;



public class Controller_Form_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		try {
			String id_vol=request.getParameter("idvol");
			int idvol=Integer.parseInt(id_vol);
			
			String Nb_Place_aff=request.getParameter("nbplace_aff");
			int nb_placeaff=Integer.parseInt(Nb_Place_aff);	
			
			String Nb_Place_eco=request.getParameter("nbplace_eco");
			int nb_placeeco=Integer.parseInt(Nb_Place_eco);
			
			String p=request.getParameter("prix");
			int prix=Integer.parseInt(p);	
			
			request.setAttribute("idvol",idvol);
			request.setAttribute("prix",prix);
			request.setAttribute("nbplace_aff",nb_placeaff);
			request.setAttribute("nbplace_eco", nb_placeeco);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        
		
		
        request.getRequestDispatcher("/WEB-INF/Form_Reservation.jsp").forward(request, response);
        
    }
       
}

