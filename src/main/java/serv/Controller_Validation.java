package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Vol;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import connex.Connect;


public class Controller_Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id=request.getParameter("idvol");
		PrintWriter out = response.getWriter();
		out.print(id);
		if(id != null){
		int idvol=Integer.parseInt(id);
		Vol vols= new Vol();
        Connect conn=new Connect();
        Connection c=conn.Connex();
        vols.valider(c,idvol);
       response.sendRedirect("Controller_Admin");
		}
	}
}
