
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="vols.*"%>
<%@ page import="avion.*"%>
<%@ page import="java.util.Date" %>

<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="vols.*"%>
<%

Vol[] vols=(Vol[])request.getAttribute("Encours");
Avion[] avions=(Avion[])request.getAttribute("avions");
%>
</head>
<body>
    <h1>Liste des vols en cours de validation</h1>  
    <table>
        <tr>
            <th>id</th>
            <th>Numero du vol</th>
            <th>Avion</th>
            <th>Source</th>
            <th>Destination</th>
            <th>Date de départ</th>
            <th>Heure de départ</th>
            <th>Durée du vol</th>
            <th>Prix</th>
            <th>Place Affaire dispo </th>
            <th>Place Eco dispo </th>
            
        </tr>
        <tr>
            <% for(int i=0;i<vols.length;i++){ %>
          
                
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
                    <td><%= avions[i].getNb_placeaff()  %></td>
                    <td><%= avions[i].getNb_placeeco() %></td>
                    <td>
                    <td>
			        <form method="get" action="<%= request.getContextPath() %>/Controller_Validation">
            			<input type="hidden" value="<%= vols[i].getId_Vol() %>" name="idvol">
            		<button type="submit">Valider</button>
            		</form>
        			</td> 
                
                 
			         
        		</tr>
        <% } %>
        		
      </table>

	</body>
	</html>
      
      