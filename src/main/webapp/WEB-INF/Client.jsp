<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vols.*"%>
<%

Vol[] vols=(Vol[])request.getAttribute("listeVol");

%>




<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Liste des vols</h1>
    
    <table>
        <tr>
            <td>id</td>
            <td>Avion</td>
            <td>Source</td>
            <td>Destination</td>
            <td>Date de départ</td>
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
                    <td><%= vols[i].getDate_vol() %></td>
                    <td><%= vols[i].getPrix() %></td>
                	<td>
                        <button type="submit">Reserver</button>
                	</td>  
            	</tr>
            	</form>
            	<% } %>
    </table>

</body>
</html>
