<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Formulaire d'insertion de Vol</h1>
    <form method="post" action="<%= request.getContextPath()%>/Controller_Plan_Vol">
    
    	<label for="numero">Numero du Vol:</label>
        <input type="number" name="numero_vol" required><br>
        
        <label for="type_trajet">Trajet:</label>
        <select name="type_trajet" id="type_trajet">
        	<option value="Choisir">Choisir</option>
            <option value="0">Aller</option>
            <option value="1">Aller-Retour</option>
        </select><br>
        
        <label for="id_avion">ID Avion:</label>
        <input type="number" name="id_avion" required><br>
        
        <label for="source">Source:</label>
        <input type="text" name="source" required><br>
        
        <label for="destination">Destination:</label>
        <input type="text" name="destination" required><br>
        
        <label for="date_vol">Date Vol:</label>
        <input type="datetime-local" name="date_vol" required><br>
        
        <label for="date_vol">Durée du vol:</label>
       <input type="time" name="duree_vol" ><br>

        <label for="prix">Prix:</label>
        <input type="number" name="prix" required><br>
        
        <label for="date_soumis">Date de soumission:</label>
        <input type="datetime-local" name="date_soumis" required><br>
        
        
        <input type="submit" value="Insérer Vol">
    </form>
</body>
</html>
		