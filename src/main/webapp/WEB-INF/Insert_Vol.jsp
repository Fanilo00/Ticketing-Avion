<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
    <h1>Formulaire d'insertion de Vol</h1>
    <form method="post" action="<%= request.getContextPath()%>/Controller_Employer">
        <label for="id_avion">ID Avion:</label>
        <input type="number" name="id_avion" required><br>
        <label for="source">Source:</label>
        <input type="text" name="source" required><br>
        
        <label for="destination">Destination:</label>
        <input type="text" name="destination" required><br>
        
        <label for="date_vol">Date Vol:</label>
        <input type="datetime-local" name="date_vol" required><br>
        
        <label for="prix">Prix:</label>
        <input type="number" name="prix" required><br>
        
        <input type="submit" value="Insérer Vol">
    </form>
</body>
</html>
		