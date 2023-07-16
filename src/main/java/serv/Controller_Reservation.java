package serv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;


import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Promotion;
import vols.Vol;


public class Controller_Reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   
    	   String id_vol=request.getParameter("id_vol");
    	   String numero =request.getParameter("numero_vol");
    	   int num_vol = Integer.parseInt(numero);
    	   int idvol=Integer.parseInt(id_vol);
    	   Connect conn=new Connect();
	       Connection c=conn.Connex();
	       Promotion prom = Promotion.get_Promotion(c,idvol);
	       Timestamp exp_prom= prom.getDatefin();
	       long currentTimeMillis = System.currentTimeMillis();
	       Timestamp currentdate = new Timestamp(currentTimeMillis);
	       
	       if(prom!=null)
	       {
	    	   if(currentdate.before(exp_prom))
	    	   {
	    		   
	    	   }
	       }
	       
    	   
    	   
       }

}
