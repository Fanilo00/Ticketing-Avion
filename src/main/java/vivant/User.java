package vivant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class User {

	 	int id_User;
	 	String nom;
	    String email;
	    String password;
	    int role;
		public int getId_User() {
			return id_User;
		}
		public void setId_User(int id_User) {
			this.id_User = id_User;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		public User() {

		}
		
		public User(int id_User,String nom, String email, String password, int role) {
			this.setId_User(id_User);
			this.setNom(nom);
			this.setEmail(email);
			this.setPassword(password);
			this.setRole(role);
		}
		public User(String nom, String email, String password) {
			this.setNom(nom);
			this.setEmail(email);
			this.setPassword(password);
		}
	    
		public static User get_User_by_mailpass(Connection con,String email,String pass) 
	    {
	        
	        User us=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Users where Email=" + email + "and Password=" + pass;
	     	        ResultSet result = stmnt.executeQuery(sql);

	     	        while (result.next()) {
	     	            int Id_User = result.getInt("Id_User");
	     	            String nom =result.getString("Nom");
	     	            String mail = result.getString("Email");
	     	            String pwd = result.getString("Password");
	     	            int role = result.getInt("Role");

	     	            us = new User(Id_User,nom,mail,pwd,role);
	     	        }
	     	        result.close();
	     	        stmnt.close();
	        	}
	     
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return us;
	    }
		
		public void Signup_Client(Connection con)
		{
			try {
	            if (con!=null) {
	                String sql = "INSERT INTO Users VALUES (default,? , ?, ?, 3)";
	                PreparedStatement stmt = con.prepareStatement(sql);
	                stmt.setString(1,this.getNom());
	                stmt.setString(2,this.getEmail());
	                stmt.setString(3,this.getPassword());
	                stmt.executeUpdate();
	                stmt.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		}
	   

}

