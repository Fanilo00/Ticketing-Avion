package serv;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import connex.Connect;
import vivant.User;

public class Controller_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connect conn=new Connect();
    Connection c=conn.Connex();
	String email = request.getParameter("email");
	String password = request.getParameter("pass");

	
	if(email.compareTo(User.get_User_by_mailpass(c, email, password).getEmail())==0
	&& password.compareTo(User.get_User_by_mailpass(c, email, password).getPassword())==0)
	{
		if(User.get_User_by_mailpass(c, email, password).getRole()==0)
		{
			request.getRequestDispatcher("/WEB-INF/Admin.jsp").forward(request, response);
		}
		else if(User.get_User_by_mailpass(c, email, password).getRole()==1)
		{
			request.getRequestDispatcher("/WEB-INF/Employer.jsp").forward(request, response);
		}
		else if(User.get_User_by_mailpass(c, email, password).getRole()==2)
		{
			request.getRequestDispatcher("/WEB-INF/Client.jsp").forward(request, response);
		}
		
	}else {
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
		
		
	}

}