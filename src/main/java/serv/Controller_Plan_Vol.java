package serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;

public class Controller_Plan_Vol extends HttpServlet {


	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connect con = new Connect();
            try (Connection co = con.Connex()) {
                int num_vol = Integer.parseInt(request.getParameter("numero_vol"));
                int id_avion = Integer.parseInt(request.getParameter("id_avion"));
                String source = request.getParameter("source");
                String destination = request.getParameter("destination");
                String dateStr = request.getParameter("date_vol");
                String dureeStr = request.getParameter("duree_vol");
                int prix = Integer.parseInt(request.getParameter("prix"));
                int type_trajet = Integer.parseInt(request.getParameter("type_trajet"));

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                Date parsedDate = dateFormat.parse(dateStr);
                Timestamp daty = new Timestamp(parsedDate.getTime());

                double duree_vol = Vol.getHeureEnDecimal(dureeStr);

     
                Vol v1 = new Vol(num_vol, id_avion, source, destination, daty, duree_vol, prix, type_trajet);
               
                
                if(type_trajet==0)
                {
                	 v1.insert_vol(co);
                }
                
                if (type_trajet == 1) {
                	 v1.insert_vol(co);
                    String[] heuresToAddStr = { dureeStr, "02:00" };
                    
                    
                    String date_vol_retour = Vol.addHeuresToDate(dateStr, heuresToAddStr);
                    System.out.print(date_vol_retour);
                    Date parsedDateRetour = dateFormat.parse(date_vol_retour);
                    Timestamp datyRetour = new Timestamp(parsedDateRetour.getTime());

                    
                    Vol v2 = new Vol(num_vol, id_avion, destination, source, datyRetour, duree_vol, prix, type_trajet);
                    v2.insert_vol(co);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("Controller_Emp");
    }
}


