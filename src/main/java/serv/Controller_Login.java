package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import connex.Connect;
import vivant.User;

public class Controller_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connect conn=new Connect();
	PrintWriter out = response.getWriter();
    Connection c=conn.Connex();
	String email = request.getParameter("email");
	String password = request.getParameter("pass");
	
	
	if(email.compareTo(User.get_User_by_mailpass(c, email, password).getEmail())==0
	&& password.compareTo(User.get_User_by_mailpass(c, email, password).getPassword())==0)
	{
		out.print(User.get_User_by_mailpass(c, email, password).getEmail());
		if(User.get_User_by_mailpass(c, email, password).getRole()==1)
		{
			response.sendRedirect("Controller_Admin");
		}
		else if(User.get_User_by_mailpass(c, email, password).getRole()==2)
		{
			response.sendRedirect("Controller_Emp");
		}
		else if(User.get_User_by_mailpass(c, email, password).getRole()==3)
		{
			
			response.sendRedirect("Controller_Client");
		}
		
	}else{
		response.sendRedirect("Controller_Index");
	}
		
		
	}

}