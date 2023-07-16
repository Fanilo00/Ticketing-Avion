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
	
	private static final long serialVersionUID = 8074648723420083093L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
        try {
        	Connect con= new Connect();
    		Connection co = con.Connex();
    		
    		String numero= request.getParameter("numero_vol");
    	    int num_vol=Integer.parseInt(numero);
    	    
            String idavion= request.getParameter("id_avion");
            int id_avion=Integer.parseInt(idavion);
            
            String source=request.getParameter("source");
            
            String destination=request.getParameter("destination");
            
            String date=request.getParameter("date_vol");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date parsedDate = dateFormat.parse(date);
            
            String duree=request.getParameter("duree_vol");
            
            Timestamp daty = new Timestamp(parsedDate.getTime());
            String price= request.getParameter("prix");
            int prix=Integer.parseInt(price);
            Timestamp date_soumis=new Timestamp(parsedDate.getTime());
            String types = request.getParameter("type_trajet");
            int type_trajet =Integer.parseInt(types);
            
            
            
            if(type_trajet==0)
            {
            	double duree_vol = Vol.getHeureEnDecimal(duree);
            	Vol v=new Vol(num_vol,id_avion,source,destination,daty,duree_vol,prix,date_soumis,type_trajet);
            	v.insert_vol(co);
            }else {
            	
            	double duree_vol = Vol.getHeureEnDecimal(duree);
            	
            	Vol v1 =new Vol(num_vol,id_avion,source,destination,daty,duree_vol,prix,date_soumis,type_trajet);
            	v1.insert_vol(co);
            	
            	String[] heuresToAddStr = { duree , "02:00" };
                String date_vol = Vol.addHeuresToDate(date,heuresToAddStr); 
                Date isDate = dateFormat.parse(date_vol);
                Timestamp daty2 = new Timestamp(isDate.getTime());
   
            	Vol v2 =new Vol(num_vol,id_avion,source,destination,daty2,duree_vol,prix,date_soumis,type_trajet);
            	v2.insert_vol(co);
            }
            
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
	        response.sendRedirect("Controller_Emp");
	}
}
