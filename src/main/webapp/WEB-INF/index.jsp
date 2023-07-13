<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
    <form method="post" action="<%= request.getContextPath()%>/Controller_Login">
        <label for="email">Email:</label>
        <input type="email" name="email" required><br>
        <label for="password">Mot de passe:</label>
        <input type="password" name="pass" required><br>
        <button type="submit">Se connecter</button>
    </form>
    <a href="<%= request.getContextPath()%>/Controller_Show_Inscription">S'inscrir</a>

</body>
</html>