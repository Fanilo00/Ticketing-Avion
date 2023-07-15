<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vols.*"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%

Vol[] vols=(Vol[])request.getAttribute("listeVol");


%>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Liste des vols</h1>
     <a href="<%= request.getContextPath() %>/Insert_Vol"><button type="submit">Ajouter un vol</button></a>
    <table>
        <tr>
            <td>id</td>
            <td>Numero du vol</td>
            <td>Avion</td>
            <td>Source</td>
            <td>Destination</td>
            <td>Date de départ</td>
            <td>Durée du vol</td>
            <td>Prix</td>
        </tr>
        <tr>
            <% for(int i=0;i<vols.length;i++){ %>
            <form method="post" action="Controller_Form_Reservation">
                <input type="hidden" value="<%= vols[i].getId_Vol() %>" name="idvol">
                <input type="hidden" value="<%= vols[i].getNumero_vol() %>" name="numvol">
                <input type="hidden" value="<%= vols[i].getSource() %>" name="source">
                <input type="hidden" value="<%= vols[i].getDestination() %>" name="destination">
                <input type="hidden" value="<%= vols[i].getDate_vol() %>" name="daty">
                
                <tr>
                    <td><%= vols[i].getId_Vol() %></td>
                    <td><%= vols[i].getNumero_vol() %></td>
                    <td><%= vols[i].getId_avion() %></td>
                    <td><%= vols[i].getSource() %></td>
                    <td><%= vols[i].getDestination() %></td>
                    
  
                    <%
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

                        Date dateVol = vols[i].getDate_vol();
                        String dateStr = dateFormat.format(dateVol);
                        String timeStr = timeFormat.format(dateVol);
                    %>
                    
                    <td><%= dateStr %></td>
                    <td><%= timeStr %></td>
                    
                    <%
                        double dureeVol = vols[i].getDuree_vol();
                        long heures = (long) dureeVol;
                        long minutes = Math.round((dureeVol - heures) * 60);

                        String dureeStr = String.format("%02dH%02d", heures, minutes);
                    %>
                    
                    <td><%= dureeStr %></td>
                    
                    <td><%= vols[i].getPrix() %></td>
                    <td>
                        <button type="submit">Réserver</button>
                    </td>  
                </tr>
            </form>
            <% } %>
    </table>

</body>
</html>
