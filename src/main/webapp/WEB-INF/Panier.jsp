<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="vols.Vol" %>
    <%@ page import="avion.Avion" %>
    <%@ page import="java.util.Date" %>
	<%@ page import="java.text.SimpleDateFormat" %>
   <%
   
   Vol vols=(Vol)request.getAttribute("vol");
   Avion avions=(Avion)request.getAttribute("avion");
   int id_vol=(int)request.getAttribute("idvol");
   int prixEco=(int)request.getAttribute("prixEco");
   int prixAff=(int)request.getAttribute("prixAff");
   int total=(int)request.getAttribute("total");
   int placeAffaireRes=(int)request.getAttribute("placeAffaire");
   int placeEcoRes=(int)request.getAttribute("placeEco");
  
   
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Votre Panier</h1>
    <table>
        <tr>
            <th>id</th>
            <th>Numero du vol</th>
            <th>Avion</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Nb Aff Res</th>
            <th>Nb Eco Res</th>
            <th>Date départ</th>
            <th>Heure départ</th>
            <th>Durée du vol</th>
            <th>Prix</th>
            <th>Place Affaire dispo </th>
            <th>Place Eco dispo </th>
            <th>Montant Eco</th>
            <th>Montant Affaire</th>
            <th>Total</th>
        </tr>
        
        <%
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String dateStr = dateFormat.format(vols.getDate_vol());
            String timeStr = timeFormat.format(vols.getDate_vol());
            
            double dureeVol = vols.getDuree_vol();
            long heures = (long) dureeVol;
            long minutes = Math.round((dureeVol - heures) * 60);
            String dureeStr = String.format("%02dH%02d", heures, minutes);
        %>
        
        <tr>
            <td><%= vols.getId_avion() %></td>
            <td><%= vols.getNumero_vol() %></td>
            <td><%= vols.getId_avion() %></td>
            <td><%= vols.getSource() %></td>
            <td><%= vols.getDestination() %></td>
            <td><%= placeAffaireRes %></td>
            <td><%= placeEcoRes %></td>
            <td><%= dateStr %></td>
            <td><%= timeStr %></td>
            <td><%= dureeStr %></td>
            <td><%= vols.getPrix() %></td>
            <td><%= avions.getNb_placeaff()  %></td>
			<td><%= avions.getNb_placeeco() %></td>
			<td><%= prixEco %></td>
			<td><%= prixAff %></td>
			<td><%= total %></td>
			
        </tr>
        
    </table>


	

</body>
</html>