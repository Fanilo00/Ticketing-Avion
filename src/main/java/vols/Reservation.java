package vols;

import avion.*;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reservation {
        int id_Reservation;
        Vol vol;
        Classe classe;
        int placeReserver;
        String nom_passager;
        Timestamp date_reservation;
        
        public int getId_Reservation() {
            return id_Reservation;
        }
        public void setId_Reservation(int id_Reservation) {
            this.id_Reservation = id_Reservation;
        }
        public Vol getVol() {
            return vol;
        }
        public void setVol(Vol vol) {
            this.vol = vol;
        }
        public Classe getClasse() {
            return classe;
        }
        public void setClasse(Classe classe) {
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

        public void insertReservation(Connection con) {
            try {
                String sql = "INSERT INTO Reservation (Id_Vol, Id_Classe, PlaceReserver, Nom_passager, Date_Reservation) VALUES (?, ?, ?, ?, current_timestamp)";
                PreparedStatement statement = con.prepareStatement(sql);

                statement.setInt(1, this.vol.getId_Vol());
                statement.setInt(2, this.classe.getId_Classe());
                statement.setInt(3, this.placeReserver);
                statement.setString(4, this.nom_passager);	

                statement.executeUpdate();

                System.out.println("Réservé!");
            } catch (SQLException e)
            {
                System.out.println("Erreur " + e.getMessage());
            }
        }

        
}