package vols;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class Vol {
	
	    int id_Vol; 
	    int numero_vol;
	    int id_avion;
	    String source;
	    String destination;
	    Timestamp Date_vol;
	    int prix;
	    boolean validations;

	   
	    public Vol() {
	    }
	    public Vol(int id_Vol, int numero_vol, int id_avion, String source, String destination, Timestamp Date_vol,int prix, boolean validations) {
	        this.setId_Vol(id_Vol);
	        this.setNumero_vol(numero_vol);
	        this.setId_avion(id_avion);
	        this.setSource(source);
	        this.setDestination(destination);
	        this.setDate_vol(Date_vol);
	        this.setPrix(prix);
	        this.setValidations(validations);
	    }
	    public int getId_Vol() {
	        return id_Vol;
	    }
	    public void setId_Vol(int id_Vol) {
	        this.id_Vol = id_Vol;
	    }
	    public int getNumero_vol() {
	        return numero_vol;
	    }
	    public void setNumero_vol(int numero_vol) {
	        this.numero_vol = numero_vol;
	    }
	    public int getId_avion() {
	        return id_avion;
	    }
	    public void setId_avion(int id_avion) {
	        this.id_avion = id_avion;
	    }
	    public String getSource() {
	        return source;
	    }
	    public void setSource(String source) {
	        this.source = source;
	    }
	    public String getDestination() {
	        return destination;
	    }
	    public void setDestination(String destination) {
	        this.destination = destination;
	    }
	    public Timestamp getDate_vol() {
	        return Date_vol;
	    }
	    public void setDate_vol(Timestamp Date_vol) {
	        this.Date_vol = Date_vol;
	    }
	    public int getPrix() {
	        return prix;
	    }
	    public void setPrix(int prix) {
	        this.prix = prix;
	    }
	    public boolean isValidations() {
			return validations;
		}
		public void setValidations(boolean validations) {
			this.validations = validations;
		}
		
		
		
		public  Vol[] get_ListeVols_valide(Connection con) 
	    {
	        Vector<Vol> vect = new Vector<Vol>();
	        Vol[] voleListe=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Vol where Validations='true'";
	     	        ResultSet result = stmnt.executeQuery(sql);

	     	        while (result.next()) {
	     	            int Id_Vol = result.getInt("Id_Vol");
	     	            int num_vol=result.getInt("Numero_vol");
	     	            int Id_Avion = result.getInt("Id_Avion");
	     	            String Source = result.getString("Source");
	     	            String Destination = result.getString("Destination");
	     	            Timestamp Date_vol = result.getTimestamp("Date_vol");
	     	            int Prix = result.getInt("Prix");
	     	            boolean Validations = result.getBoolean("Validations");

	     	            Vol vol = new Vol(Id_Vol,num_vol,Id_Avion,Source,Destination,Date_vol,Prix,Validations);
	     	            vect.add(vol);
	     	        }
	     	        voleListe=new Vol[vect.size()];
	     	        vect.copyInto(voleListe);
	     	        result.close();
	     	        stmnt.close();
	        	}
	     
	       
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return voleListe;
	    }
		
		
		public  Vol[] get_ListeVols_invalide(Connection con) 
	    {
	        Vector<Vol> vect = new Vector<Vol>();
	        Vol[] voleListe=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Vol where Validations='false'";
	     	        ResultSet result = stmnt.executeQuery(sql);

	     	        while (result.next()) {
	     	            int Id_Vol = result.getInt("Id_Vol");
	     	            int num_vol=result.getInt("Numero_vol");
	     	            int Id_Avion = result.getInt("Id_Avion");
	     	            String Source = result.getString("Source");
	     	            String Destination = result.getString("Destination");
	     	            Timestamp Date_vol = result.getTimestamp("Date_vol");
	     	            int Prix = result.getInt("Prix");
	     	            boolean Validations = result.getBoolean("Validations");

	     	            Vol vol = new Vol(Id_Vol,num_vol,Id_Avion,Source,Destination,Date_vol,Prix,Validations);
	     	            vect.add(vol);
	     	        }
	     	        voleListe=new Vol[vect.size()];
	     	        vect.copyInto(voleListe);
	     	        result.close();
	     	        stmnt.close();
	        	}
	     
	       
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return voleListe;
	    }
		
		
		public  Vol[] get_All_ListeVols(Connection con) 
	    {
	        Vector<Vol> vect = new Vector<Vol>();
	        Vol[] voleListe=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Vol";
	     	        ResultSet result = stmnt.executeQuery(sql);

	     	        while (result.next()) {
	     	            int Id_Vol = result.getInt("Id_Vol");
	     	            int num_vol=result.getInt("Numero_vol");
	     	            int Id_Avion = result.getInt("Id_Avion");
	     	            String Source = result.getString("Source");
	     	            String Destination = result.getString("Destination");
	     	            Timestamp Date_vol = result.getTimestamp("Date_vol");
	     	            int Prix = result.getInt("Prix");
	     	            boolean Validations = result.getBoolean("Validations");

	     	            Vol vol = new Vol(Id_Vol,num_vol,Id_Avion,Source,Destination,Date_vol,Prix,Validations);
	     	            vect.add(vol);
	     	        }
	     	        voleListe=new Vol[vect.size()];
	     	        vect.copyInto(voleListe);
	     	        result.close();
	     	        stmnt.close();
	        	}
	     
	       
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return voleListe;
	    }
		
		
		public void valider(Connection con,int id_vol)
		{
			try {
	            if (con!=null) {
	                String sql = "Update Vol set Validations='true' where id_vol="+ id_vol;
	                PreparedStatement stmt = con.prepareStatement(sql);
	                stmt.executeUpdate();
	                
	                stmt.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}
		
	    public void insert_vol(Connection con) {
	        try {
	            if (con!=null) {
	                String sql = "INSERT INTO Vol VALUES (?, ?, ?, ?, ?)";
	                PreparedStatement stmt = con.prepareStatement(sql);
	                
	                stmt.setInt(1, this.getId_avion());
	                stmt.setString(2, this.getSource());
	                stmt.setString(3, this.getDestination());
	                stmt.setTimestamp(4, this.getDate_vol());
	                stmt.setInt(5, this.getPrix());
	                
	                stmt.executeUpdate();
	                
	                stmt.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
