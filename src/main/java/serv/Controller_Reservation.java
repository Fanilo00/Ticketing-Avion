package serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Timestamp;

import avion.Avion;
import connex.Connect;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vols.Promotion;
import vols.Reservation;
import vols.Vol;

public class Controller_Reservation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connect conn = new Connect();
        Connection c = conn.Connex();
    	
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String id_vol = request.getParameter("id_vol");
        String nbplaceaffdispo = request.getParameter("nbplaceaff");
        String nbplaceecodispo = request.getParameter("nbplaceeco");
        String nom = request.getParameter("nom");
        String nbplaceaffres = request.getParameter("nbPlaceAffRes");
        String nbplaceecores = request.getParameter("nbPlaceEcoRes");
        
   
        
        
        int idvol = Integer.parseInt(id_vol);
        int nb_place_Aff_dispo = Integer.parseInt(nbplaceaffdispo);
        int nb_place_Eco_dispo = Integer.parseInt(nbplaceecodispo);
        int nb_place_Aff_res = Integer.parseInt(nbplaceaffres);
        int nb_place_Eco_res = Integer.parseInt(nbplaceecores);

        Vol vo = Vol.get_Vol_byId(c, idvol);

        int prix = vo.getPrix();

        Promotion prom = Promotion.get_Promotion(c, idvol);
        Timestamp exp_prom = (prom != null) ? prom.getDatefin() : null;
        long currentTimeMillis = System.currentTimeMillis();
        Timestamp currentdate = new Timestamp(currentTimeMillis);

        if ((nb_place_Aff_dispo >= nb_place_Aff_res) && (nb_place_Eco_dispo >= nb_place_Eco_res)) {
            Reservation r = new Reservation(idvol, nb_place_Aff_res, nb_place_Eco_res, nom);
            r.insertReservation(c);

            int totalEco = prix * nb_place_Eco_res;
            int totalAff = prix * nb_place_Aff_res;
            int total = totalEco + totalAff;

            if (prom != null && currentdate.before(exp_prom)) {
                if (prom.getClasse() == 0) {
                    double nbaffprom = nb_place_Aff_dispo * 0.02;
                    int nbAffprom = (int) nbaffprom;

                    if (nbAffprom > nb_place_Aff_res) {
                        double priprom = prix * 0.05;
                        int prixAff = (int) priprom;
                        totalEco = prix * nb_place_Eco_res;
                        totalAff = prixAff * nb_place_Aff_res;
                        total = totalEco + totalAff;
                    }
                }

                if (prom.getClasse() == 1) {
                    double nbecoprom = nb_place_Eco_dispo * 0.02;
                    int nbEcoprom = (int) nbecoprom;

                    if (nbEcoprom > nb_place_Eco_res) {
                        double priprom = prix * 0.05;
                        int prixEco = (int) priprom;
                        totalAff = prix * nb_place_Aff_res;
                        totalEco = prixEco * nb_place_Eco_res;
                        total = totalEco + totalAff;
                    }
                }
            }

            Vol vo2 = Vol.get_Vol_byId(c, idvol);
            Avion av = Avion.get_Avion_by_Id(c, idvol);
            request.setAttribute("vol", vo2);
            request.setAttribute("idvol", idvol);
            request.setAttribute("avion", av);
            request.setAttribute("placeAffaire", nb_place_Aff_res);
            request.setAttribute("placeEco", nb_place_Eco_res);
            request.setAttribute("prixEco", totalEco);
            request.setAttribute("prixAff", totalAff);
            request.setAttribute("total", total);

            request.getRequestDispatcher("/WEB-INF/Panier.jsp").forward(request, response);

        } else {

            String mess = "Place insuffisant";
            request.setAttribute("Message", mess);
            request.getRequestDispatcher("/WEB-INF/Form_Reservation.jsp").forward(request, response);
        }
    }
}
