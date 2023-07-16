package vols;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class Vol {
	
	
	int id_Vol; 
    int numero_vol;
	int id_avion;
    String source;
    String destination;
    Timestamp Date_vol;
    double duree_vol;
    int prix;
    Timestamp datesoumi;
    boolean validation;
    Timestamp datevalide;
    int type_trajet;

	  
		public Vol() {
	    }
	    public Vol(int id_Vol, int numero_vol, int id_avion, String source, String destination, Timestamp Date_vol,double duree,int prix, boolean validations,int type_trajet) {
	        this.setId_Vol(id_Vol);
	        this.setNumero_vol(numero_vol);
	        this.setId_avion(id_avion);
	        this.setSource(source);
	        this.setDestination(destination);
	        this.setDate_vol(Date_vol);
	        this.setDuree_vol(duree);
	        this.setPrix(prix);
	        this.setValidation(validations);
	        this.setType_trajet(type_trajet);
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
	    public int getPrix() {
	        return prix;
	    }
	    public void setPrix(int prix) {
	        this.prix = prix;
	    }
	    public boolean getValidation() {
			return validation;
		}
		public void setValidation(boolean validations) {
			this.validation = validations;
		}
		
	   public Timestamp getDatesoumi() {
			return datesoumi;
		}
		public void setDatesoumi(Timestamp datesoumi) {
			this.datesoumi = datesoumi;
		}
		public Timestamp getDatevalide() {
			return datevalide;
		}
		public void setDatevalide(Timestamp datevalide) {
			this.datevalide = datevalide;
		}
		public double getDuree_vol() {
			return duree_vol;
		}
		public void setDuree_vol(double duree_vol) {
			this.duree_vol = duree_vol;
		}
		public int getType_trajet() {
			return type_trajet;
		}
		public void setType_trajet(int type_trajet) {
			this.type_trajet = type_trajet;
		}
		
		public Timestamp getDate_vol() {
			return Date_vol;
		}
		public void setDate_vol(Timestamp date_vol) {
			this.Date_vol = date_vol;
		}
		public Vol(int numero_vol, int id_avion, String source, String destination,Timestamp date_vol,double duree,
				int prix,int type_trajet) {
			this.setNumero_vol(numero_vol);
			this.setId_avion(id_avion);
			this.setSource(source);
			this.setDestination(destination);
			this.setDate_vol(date_vol);
			this.setDuree_vol(duree);
			this.setPrix(prix);
			this.setType_trajet(type_trajet);
		}
		
		public Vol(int id_Vol, int numero_vol, int id_avion, String source, String destination,Timestamp date_vol,double duree,
				int prix, Timestamp datesoumi, boolean validation, Timestamp datevalide,int type_trajet) {
				this.setId_Vol(id_Vol);
				this.setNumero_vol(numero_vol);
				this.setId_avion(id_avion);
				this.setSource(source);
				this.setDestination(destination);
				this.setDate_vol(date_vol);
				this.setDuree_vol(duree);
				this.setPrix(prix);
				this.setDatesoumi(datesoumi);
				this.setValidation(validation);
				this.setDatevalide(datevalide);
				this.setType_trajet(type_trajet);
			}
		
			
		public  Vol[] get_Vols_Valide(Connection con) 
	    {
	        Vector<Vol> vect = new Vector<Vol>();
	        Vol[] voleListe=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Vol where est_valide='true'";
	     	        ResultSet result = stmnt.executeQuery(sql);

	     	        while (result.next()) {
	     	            int Id_Vol = result.getInt("Id_Vol");
	     	            int num_vol=result.getInt("Numero_vol");
	     	            int Id_Avion = result.getInt("Id_Avion");
	     	            String Source = result.getString("Source");
	     	            String Destination = result.getString("Destination");
	     	            Timestamp Date_vol = result.getTimestamp("Date_vol");
	     	            double duree = result.getDouble("Duree_vol");
	     	            int Prix = result.getInt("Prix");
	     	            Timestamp date_soumission = result.getTimestamp("date_soumission");
	     	            boolean Validations = result.getBoolean("est_valide");
	     	            Timestamp date_valide = result.getTimestamp("date_validation");
	     	            int type_trajet = result.getInt("type_trajet");
	     	            Vol vol = new Vol(Id_Vol,num_vol,Id_Avion,Source,Destination,Date_vol,duree,Prix,date_soumission,Validations,date_valide,type_trajet);
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
		
		
		
		
		public static Vol get_Vol_byId(Connection con,int idvol) 
	    {
	        Vol vol=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Vol where est_valide='true' and id_vol=" + idvol;
	     	        ResultSet result = stmnt.executeQuery(sql);
	     	        while (result.next()) 
	     	        {
	     	            int Id_Vol = result.getInt("Id_Vol");
	     	            int num_vol=result.getInt("Numero_vol");
	     	            int Id_Avion = result.getInt("Id_Avion");
	     	            String Source = result.getString("Source");
	     	            String Destination = result.getString("Destination");
	     	            Timestamp Date_vol = result.getTimestamp("Date_vol");
	     	            double duree = result.getDouble("Duree_vol");
	     	            int Prix = result.getInt("Prix");
	     	            Timestamp date_soumission = result.getTimestamp("date_soumission");
	     	            boolean Validations = result.getBoolean("est_valide");
	     	            Timestamp date_valide = result.getTimestamp("date_validation");
	     	            int type = result.getInt("type_trajet");

	     	            vol = new Vol(Id_Vol,num_vol,Id_Avion,Source,Destination,Date_vol,duree,Prix,date_soumission,Validations,date_valide,type);
	     	        }
	     	        	
	     	        result.close();
	     	        stmnt.close();
	        	}
	     
	       
	        
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return vol;
	    }
		
		public  Vol[] get_Vols_Encours(Connection con) 
	    {
	        Vector<Vol> vect = new Vector<Vol>();
	        Vol[] voleListe=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "select * from vol where est_valide='false' and date_soumission<=current_timestamp and current_timestamp<=date_soumission + interval '2 weeks'";
	     	        ResultSet result = stmnt.executeQuery(sql);

	     	        while (result.next()) {
	     	            int Id_Vol = result.getInt("Id_Vol");
	     	            int num_vol=result.getInt("Numero_vol");
	     	            int Id_Avion = result.getInt("Id_Avion");
	     	            String Source = result.getString("Source");
	     	            String Destination = result.getString("Destination");
	     	            Timestamp Date_vol = result.getTimestamp("Date_vol");
	     	            double duree = result.getDouble("Duree_vol");
	     	            int Prix = result.getInt("Prix");
	     	            Timestamp date_soumission = result.getTimestamp("date_soumission");
	     	            boolean Validations = result.getBoolean("est_valide");
	     	            Timestamp date_valide = result.getTimestamp("date_validation");
	     	            int type = result.getInt("type_trajet");
	     	            Vol vol = new Vol(Id_Vol,num_vol,Id_Avion,Source,Destination,Date_vol,duree,Prix,date_soumission,Validations,date_valide,type);
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
	     	            double duree= result.getDouble("Duree_vol");
	     	            int Prix = result.getInt("Prix");
	     	            Timestamp date_soumission = result.getTimestamp("date_soumission");
	     	            boolean Validations = result.getBoolean("est_valide");
	     	            Timestamp date_valide = result.getTimestamp("date_validation");
	     	            int type = result.getInt("type_trajet");
	     	            Vol vol = new Vol(Id_Vol,num_vol,Id_Avion,Source,Destination,Date_vol,duree,Prix,date_soumission,Validations,date_valide,type);
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
	                String sql = "Update Vol set est_valide='true' where id_vol="+ id_vol;
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
	                String sql = "INSERT INTO Vol VALUES (default, ?, ?, ?, ?, ?, ?, ?,Current_Timestamp,false,null, ?)";
	                PreparedStatement stmt = con.prepareStatement(sql);
	                
	                stmt.setInt(1, this.getNumero_vol());
	                stmt.setInt(2, this.getId_avion());
	                stmt.setString(3, this.getSource());
	                stmt.setString(4, this.getDestination());
	                stmt.setTimestamp(5, this.getDate_vol());
	                stmt.setDouble(6, this.getDuree_vol());
	                stmt.setInt(7,this.getPrix());
	                stmt.setInt(8,this.getType_trajet());
	                stmt.executeUpdate();
	                stmt.close();
	                System.out.println(sql);
	            }
	        } catch (Exception e) 
	        {
	            e.printStackTrace();
	        }
	        
	        
	    }

	    
	    public static String addHeuresToDate(String dateDepartStr, String[] heuresToAddStr) {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
	        LocalDateTime dateDepart = LocalDateTime.parse(dateDepartStr, formatter);

	        for (String heureToAddStr : heuresToAddStr) {
	            LocalTime heureToAdd = LocalTime.parse(heureToAddStr);
	            dateDepart = dateDepart.plusHours(heureToAdd.getHour()).plusMinutes(heureToAdd.getMinute());
	        }

	        return dateDepart.format(formatter);
	    }

	    
	    
	    public static double getHeureEnDecimal(String heure) {
	        String[] temps = heure.split(":");
	        int heures = Integer.parseInt(temps[0]);
	        int minutes = Integer.parseInt(temps[1]);

	        double heureDecimal = heures + (minutes / 60.0);

	        // Arrondir à 2 décimales
	        heureDecimal = Math.round(heureDecimal * 100.0) / 100.0;

	        return heureDecimal;
	    }
}
