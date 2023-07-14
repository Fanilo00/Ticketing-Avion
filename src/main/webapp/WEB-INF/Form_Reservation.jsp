<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	int idvol =(int)request.getAttribute("idvol");  
int numvol =(int)request.getAttribute("numvol"); 
String source =(String)request.getAttribute("source");  
int idvol =(int)request.getAttribute("idvol");  

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
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" required><br><br>
        
        <label for="nbPlace">Nombre de places :</label>
        <input type="number" name="nbPlace" id="nbPlace" required><br><br>
        
        <label for="prix">Prix :</label>
        <input type="number" name="prix" id="prix" required><br><br>
        
        <input type="submit" value="Réserver">
    </form>
</body>
</html>
