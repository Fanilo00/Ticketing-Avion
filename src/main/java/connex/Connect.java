package connex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect {
	  public Connection Connex() {
	        String url = "jdbc:postgresql://localhost:5432/servlet";
	        String username = "postgres";
	        String password = "root";
	        Connection conn = null;

	        try {
	            // Register the PostgreSQL JDBC driver
	            Class.forName("org.postgresql.Driver");

	            // Establish the connection
	            conn = DriverManager.getConnection(url, username, password);

	        } catch (ClassNotFoundException e) {
	            System.out.println("Failed to load PostgreSQL JDBC driver.");
	            e.printStackTrace();
	        } catch (SQLException e) {
	            System.out.println("Failed to connect to the database.");
	            e.printStackTrace();
	        }

	        return conn;
	    }
}
