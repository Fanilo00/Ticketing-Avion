
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vols.*"%>
<%

Vol[] vols=(Vol[])request.getAttribute("Encours");

%>




<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Liste des vols en cours de validation</h1>
    <form method="get" action="<%= request.getContextPath() %>/Controller_Validation">
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
			        <td name="idvol" id="idvol"><%= vols[i].getId_Vol() %></td>
			        <td name="idavion" id="idavion"><%= vols[i].getId_avion() %></td>
			        <td name="source" id="source"><%= vols[i].getSource() %></td>
			        <td name="destination" id="destination"><%= vols[i].getDestination() %></td>
			        <td name="date_vol" id="date_vol"><%= vols[i].getDate_vol() %></td>
			        <td name="prix" id="prix"><%= vols[i].getPrix() %></td>
			        <td>
            		<button type="submit">Valider</button>
        			</td>  
    			</tr>
            	<% } %>
    </table>
</form>
</body>
</html>
