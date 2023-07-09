package serv;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class Controller_Emp extends HttpServlet {
	
	private static final long serialVersionUID = 3268825695494181605L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	Cookie[] cookies = request.getCookies();
	
	if (cookies != null) {
	    for (Cookie cookie : cookies) {
	        if (cookie.getName().equals("vol_cookie")) {
	            String valeurCookie = cookie.getValue();
	            JSONParser parser = new JSONParser(valeurCookie);
	            try {
	            	
	                JSONObject volJson = (JSONObject) parser.parse();
	                int id_vol = (int)volJson.get("id");
	                String source =(String)volJson.get("valeur1");
	                String destination = (String)volJson.get("valeur2");
	                String date = (String) volJson.get("depart");
	                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	                Date parsedDate = dateFormat.parse(date);
	                Timestamp daty = new Timestamp(parsedDate.getTime());
	                int prix = (int)volJson.get("prix");
	                Boolean validation = (Boolean) volJson.get("validations");
	             
	               
	                request.setAttribute("id_vol",id_vol);
	                request.setAttribute("source", source);
	                request.setAttribute("destination",destination);
	                request.setAttribute("daty", daty);
	                request.setAttribute("prix",prix);
	                request.setAttribute("validation",validation);
	                
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	            
	            request.getRequestDispatcher("/WEB-INF/Employer.jsp").forward(request, response);
	        }
	    }
	}


	}
}
