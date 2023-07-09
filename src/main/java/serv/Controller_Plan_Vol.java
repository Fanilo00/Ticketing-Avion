package serv;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.json.JSONObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Controller_Plan_Vol extends HttpServlet {
	
	private static final long serialVersionUID = 8074648723420083093L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        String idavion= request.getParameter("id_avion");
        int id_avion=Integer.parseInt("idavion");
        String source=request.getParameter("source");
        String destination=request.getParameter("destination");
        String date=request.getParameter("date_vol");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(date);
            Timestamp daty = new Timestamp(parsedDate.getTime());
            String price= request.getParameter("prix");
            int prix=Integer.parseInt("price");
           
    		JSONObject volJson = new JSONObject();
			volJson.put("idavion",id_avion);
			volJson.put("source",source);
			volJson.put("destination",destination);
			volJson.put("prix", prix);
			volJson.put("date",daty);
			volJson.put("validations","false");
			String valeurCookie = volJson.toString();
			Cookie cookie = new Cookie("vol_cookie", valeurCookie);
			response.addCookie(cookie);
			int expirationEnSec=1209600;
			cookie.setMaxAge(expirationEnSec);
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
	        request.getRequestDispatcher("/WEB-INF/Insert_Vol.jsp").forward(request, response);
	}
}
