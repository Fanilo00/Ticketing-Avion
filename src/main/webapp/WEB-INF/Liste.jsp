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
     <a href="<%= request.getContextPath() %>/Insert_Vol"><button type="submit">Ajouter un vol</button></a>
    <form method="get" action="Controller_Insert_Vol">
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
                    <td><%= vols[i].getId_Vol() %></td>
                    <td><%= vols[i].getId_avion() %></td>
                    <td><%= vols[i].getSource() %></td>
                    <td><%= vols[i].getDestination() %></td>
                    <td><%= vols[i].getDate_vol() %></td>
                    <td><%= vols[i].getPrix() %></td>
                	<td>
                        <button type="submit">Reserver</button>
                	</td>  
            	</tr>
            	<% } %>
    </table>
</form>
</body>
</html>
