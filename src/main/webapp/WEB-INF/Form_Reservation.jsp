<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<% 
	int idvol =(int)request.getAttribute("idvol"); 
	int prix =(int)request.getAttribute("prix");
	int nb_placeAff =(int)request.getAttribute("nbplace_aff");
	int nb_placeEco =(int)request.getAttribute("nbplace_eco");

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Réservation</title>
</head>
<body>
    <h1>Formulaire de réservation</h1>
    
    <form action="Controller_Reservation" method="post">
    
        <input type="hidden" value="<%= idvol %>" name="id_vol">
        <input type="hidden" value="<%= prix %>" name="id_vol">
        <input type="hidden" value="<%= nb_placeAff %>" name="nbplaceaff">
        <input type="hidden" value="<%= nb_placeEco %>" name="nbplaceeco">
        
        
        
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" required><br>
        
        <label for="nbPlace">Nombre de places Affaire  :</label>
        <input type="number" name="nbPlaceAffRes" id="nbPlaceAff" required><br>
        
        <label for="nbPlace">Nombre de places Economique  :</label>
        <input type="number" name="nbPlaceEcoRes" id="nbPlaceEco" required><br>
        
        
        <button type="submit">Valider</button>
    </form>
</body>
</html>
