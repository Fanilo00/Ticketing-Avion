<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Inscription</h1>
    <form method="post" action="<%= request.getContextPath()%>/Controller_Inscription">
        <label for="Nom">Votre Nom:</label>
        <input type="text" name="nom" required><br>
        <label for="Email">Email:</label>
        <input type="email" name="email" required><br>
        
        <label for="password">Mot de Passe:</label>
        <input type="password" name="pass" required><br>
        
        <label for="repass">Confirmer:</label>
        <input type="password" name="repass" required><br>
        
 		<button type="submit">Valider</button>
    </form>

</body>
</html>