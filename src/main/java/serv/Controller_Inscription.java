package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import vivant.User;
import connex.*;


public class Controller_Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connect con=new Connect();
		Connection co=con.Connex();
		String nom=request.getParameter("nom");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String repass=request.getParameter("repass");
		
		if(password.compareTo(repass)==0)
		{
			User u= new User(nom,email,password);
			u.Signup_Client(co);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/Inscription").forward(request, response);
		}
		
		
		
	}

}
