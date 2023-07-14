package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller_Form_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_vol=request.getParameter("idvol");
		int idvol=Integer.parseInt(id_vol);
		String num_vol=request.getParameter("numvol");
		int numero_vol=Integer.parseInt(num_vol);
		String source=request.getParameter("source");
		String destination=request.getParameter("destination");
		String daty=request.getParameter("daty");
		
		request.setAttribute("idvol",idvol);
		request.setAttribute("numvol",numero_vol);
		request.setAttribute("source",source);
		request.setAttribute("destination",destination);
		request.setAttribute("daty", daty);	
        request.getRequestDispatcher("/WEB-INF/Form_Reservation.jsp").forward(request, response);
        
    }
       
}

