<%-- 
    Document   : login
    Created on : Feb 19, 2026, 5:08:53 PM
    Author     : elliot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingreso al sistema</title>
    </head>
    <body>
        <form action="login.jsp" method="post">
            <label for="usuario">Usuario:</label>
            <input type="text" id="usuario" name="usuario"> <br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"> <br>
            <button type="submit">Ingresar</button>
        </form>
    </body>
</html>
