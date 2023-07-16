<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vols.Vol" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%

Vol[] vols=(Vol[])request.getAttribute("listeVol");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des vols</title>
</head>
<body>
    <h1>Liste des vols</h1>
    <a href="<%= request.getContextPath() %>/Insert_Vol"><button type="button">Ajouter un vol</button></a>
    
    <table>
        <tr>
            <th>id</th>
            <th>Numero du vol</th>
            <th>Avion</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Date de départ</th>
            <th>Durée du vol</th>
            <th>Prix</th>
            <th>Action</th>
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
            <td>
                <form method="post" action="Controller_Form_Reservation">
                    <input type="hidden" value="<%= vols[i].getId_Vol() %>" name="idvol">
                    <input type="hidden" value="<%= vols[i].getNumero_vol() %>" name="numvol">
                    <input type="hidden" value="<%= vols[i].getSource() %>" name="source">
                    <button type="submit">Réserver</button>
                </form>
            </td>
        </tr>
        
        <% } %>
    </table>

</body>
</html>
