<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vols.Vol" %>
<%@ page import="avion.Avion"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%

Vol[] vols=(Vol[])request.getAttribute("listevol");
Avion[] avions=(Avion[])request.getAttribute("avions");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des vols</title>
</head>
<body>
    <h1>Liste des vols</h1>
    <table>
        <tr>
            <th>id</th>
            <th>Numero du vol</th>
            <th>Avion</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Date de départ</th>
            <th>Heure de départ</th>
            <th>Durée du vol</th>
            <th>Prix</th>
            <th>Place Affaire dispo </th>
            <th>Place Eco dispo </th>
        </tr>
        
        <% for(int i=0; i < vols.length; i++) {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String dateStr = dateFormat.format(vols[i].getDate_vol());
            String timeStr = timeFormat.format(vols[i].getDate_vol());
            
            double dureeVol = vols[i].getDuree_vol();
            long heures = (long) dureeVol;
            long minutes = Math.round((dureeVol - heures) * 60);
            String dureeStr = String.format("%02dH%02d", heures, minutes);
        %>
        
        <tr>
            <td><%= vols[i].getId_avion() %></td>
            <td><%= vols[i].getNumero_vol() %></td>
            <td><%= vols[i].getId_avion() %></td>
            <td><%= vols[i].getSource() %></td>
            <td><%= vols[i].getDestination() %></td>
            <td><%= dateStr %></td>
            <td><%= timeStr %></td>
            <td><%= dureeStr %></td>
            <td><%= vols[i].getPrix() %></td>
            <td><%= avions[i].getNb_placeaff()  %></td>
			<td><%= avions[i].getNb_placeeco() %></td>
            <td>
                <form method="post" action="Controller_Form_Reservation">
                    <input type="hidden" value="<%= vols[i].getId_Vol() %>" name="idvol">
                    <input type="hidden" value="<%= vols[i].getPrix() %>" name="prix">
                    <input type="hidden" value="<%= avions[i].getNb_placeaff()  %>" name="nbplace_aff">
                    <input type="hidden" value="<%= avions[i].getNb_placeeco() %>" name="nbplace_eco">
                    <button type="submit">Réserver</button>
                </form>
            </td>
        </tr>
        
        <% } %>
    </table>

</body>
</html>
