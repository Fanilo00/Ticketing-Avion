package vols;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Reservation {
        int id_Reservation;
        int id_vol;
        int Nbplace_affaire;
        int Nbplace_eco;
        String nom_passager;
        Timestamp date_reservation;
        
        public int getId_Reservation() {
            return id_Reservation;
        }
        public void setId_Reservation(int id_Reservation) {
            this.id_Reservation = id_Reservation;
        }
        
        public int getId_vol() {
			return id_vol;
		}
		public void setId_vol(int id_vol) {
			this.id_vol = id_vol;
		}
		
        public int getNbplace_affaire() {
			return Nbplace_affaire;
		}
		public void setNbplace_affaire(int nbplace_affaire) {
			Nbplace_affaire = nbplace_affaire;
		}
		public int getNbplace_eco() {
			return Nbplace_eco;
		}
		public void setNbplace_eco(int nbplace_eco) {
			Nbplace_eco = nbplace_eco;
		}
		public String getNom_passager() {
            return nom_passager;
        }
        public void setNom_passager(String nom_passager) {
            this.nom_passager = nom_passager;
        }
        public Timestamp getDate_reservation() {
            return date_reservation;
        }
        public void setDate_reservation(Timestamp date_reservation) {
            this.date_reservation = date_reservation;
        }

        public Reservation(int id_Reservation, int vol,int placeaff, int placeeco, String nom_passager,Timestamp date_reservation)
        {
			this.setId_Reservation(id_Reservation);
			this.setId_vol(vol);
			this.setNbplace_affaire(placeaff);
			this.setNbplace_eco(placeeco);
			this.setNom_passager(nom_passager);
			this.setDate_reservation(date_reservation);
		}
        
        public Reservation(int vol,int placeaff, int placeeco, String nom_passager)
        {
			this.setId_vol(vol);
			this.setNbplace_affaire(placeaff);
			this.setNbplace_eco(placeeco);
			this.setNom_passager(nom_passager);
		}
        
        
        
        public  Reservation[] get_All_Reservations(Connection con) 
	    {
	        Vector<Reservation> vect = new Vector<Reservation>();
	       	Reservation[] resListe=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Reservation";
	     	        ResultSet result = stmnt.executeQuery(sql);

	     	        while (result.next()) {
	     	            int id_reservation = result.getInt("Id_Reservation");
	     	            int id_vol=result.getInt("Numero_vol");
	     	            int nbplaceaff = result.getInt("nbplace_affaire");
	     	            int nbplaceeco = result.getInt("nbplace_eco");
	     	            String  nom_passager = result.getString(" nom_passager");
	     	            Timestamp date_reservation = result.getTimestamp("date_reservation");
	     	            
	     	            Reservation res = new Reservation(id_reservation,id_vol,nbplaceaff,nbplaceeco,nom_passager,date_reservation);
	     	            vect.add(res);
	     	        }
	     	        resListe=new Reservation[vect.size()];
	     	        vect.copyInto(resListe);
	     	        result.close();
	     	        stmnt.close();
	        	}
	     
	       
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resListe;
	    }
        
        
        public static Reservation get_Reservations_byIdVol(Connection con,int Id_vol)
	    {
	      
	       	Reservation res=null;
	        try {
	        	if(con!=null)
	        	{
	        		Statement stmnt = con.createStatement();
	       	      
	     	        String sql = "SELECT * FROM Reservation where id_vol=" + Id_vol;
	     	        ResultSet result = stmnt.executeQuery(sql);
	     	        while (result.next()) 
	     	        {
	     	            int id_reservation = result.getInt("Id_Reservation");
	     	            int id_vol=result.getInt("id_vol");
	     	            int nbplaceaff = result.getInt("nbplace_affaire");
	     	            int nbplaceeco = result.getInt("nbplace_eco");
	     	            String  nom_passager = result.getString("nom_passager");
	     	            Timestamp date_reservation = result.getTimestamp("date_reservation");
	     	            
	     	            res = new Reservation(id_reservation,id_vol,nbplaceaff,nbplaceeco,nom_passager,date_reservation);
	     	           
	     	        }
	     	       
	     	        result.close();
	     	        stmnt.close();
	        	}
	     
	       
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return res;
	    }
        
        
		public void insertReservation(Connection con) 
        {
            try {
                String sql = "INSERT INTO Reservation VALUES (default, ?, ?, ?, ?, current_timestamp)";
              
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setInt(1, this.getId_vol());
                statement.setInt(2, this.getNbplace_affaire());
                statement.setInt(3, this.getNbplace_eco());
                statement.setString(4, this.getNom_passager());	
                statement.executeUpdate();

            } catch (SQLException e)
            {
                System.out.println("Erreur " + e.getMessage());
            }
        }
		
		
	    public static int[] getSommePlacesAffaireEco(Reservation[] reservations) {
	        int sommePlacesAffaire = 0;
	        int sommePlacesEco = 0;

	        for (Reservation reservation : reservations) {
	        		if(reservation!=null)
	        		{
	        			sommePlacesAffaire += reservation.getNbplace_affaire();
	    	            sommePlacesEco += reservation.getNbplace_eco();
	        		}
	            
	        }

	        int[] sommePlaces = new int[2];
	        sommePlaces[0] = sommePlacesAffaire;
	        sommePlaces[1] = sommePlacesEco;

	        return sommePlaces;
	    }
	}

		

        
