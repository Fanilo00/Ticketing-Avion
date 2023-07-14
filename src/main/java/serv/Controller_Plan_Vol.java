package serv;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.*;
import java.sql.Connection;
import connex.*;

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
            Date parsedDate;
            parsedDate = dateFormat.parse(date);
            Timestamp daty = new Timestamp(parsedDate.getTime());
            String price= request.getParameter("prix");
            int prix=Integer.parseInt(price);
            Timestamp date_soumis=new Timestamp(parsedDate.getTime());
            Vol v=new Vol(num_vol,id_avion,source,destination,daty,prix,date_soumis);
            v.insert_vol(co);
           
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
	        response.sendRedirect("Controller_Emp");
	}
}
