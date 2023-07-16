package vols;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reservation {
        int id_Reservation;
        int id_vol;
        String classe;
        int placeReserver;
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
		public String getClasse() {
			return classe;
		}
		public void setClasse(String classe) {
			this.classe = classe;
		}
		public int getPlaceReserver() {
            return placeReserver;
        }
        public void setPlaceReserver(int placeReserver) {
            this.placeReserver = placeReserver;
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
        
        

        public Reservation(int id_Reservation, int vol,String classe, int placeReserver, String nom_passager,Timestamp date_reservation)
        {
			this.setId_Reservation(id_Reservation);
			this.setId_vol(vol);
			this.setClasse(classe);
			this.setPlaceReserver(placeReserver);
			this.setNom_passager(nom_passager);
			this.setDate_reservation(date_reservation);
		}
		public void insertReservation(Connection con) 
        {
            try {
                String sql = "INSERT INTO Reservation (Id_Vol, Id_Classe, PlaceReserver, Nom_passager, Date_Reservation) VALUES (?, ?, ?, ?, current_timestamp)";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setInt(1, this.getId_vol());
                statement.setString(2, this.getClasse());
                statement.setInt(3, this.getPlaceReserver());
                statement.setString(4, this.getNom_passager());	
                statement.executeUpdate();

            } catch (SQLException e)
            {
                System.out.println("Erreur " + e.getMessage());
            }
        }

        
}