
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
    <h1>Liste des vols en cours de validation</h1>
    <form method="get" action="<%= request.getContextPath() %>/Validation">
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
                <tr>
                    <td name="idvol"><%= vols[i].getId_Vol() %></td>
                    <td name="idavion"><%= vols[i].getId_avion() %></td>
                    <td name="source"><%= vols[i].getSource() %></td>
                    <td name="destination"><%= vols[i].getDestination() %></td>
                    <td name="date_vol"><%= vols[i].getDate_vol() %></td>
                    <td name="prix"><%= vols[i].getPrix() %></td>
                	<td>
                        <button type="submit">Valider</button>
                	</td>  
            	</tr>
            	<% } %>
    </table>
</form>
</body>
</html>
