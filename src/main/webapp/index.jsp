<%--
    Document   : index
    Created on : Jan 29, 2026, 5:08:39 PM
    Author     : elliot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <style>
            body {
                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                min-height: 100vh;
                padding: 20px;
            }
            .main-card {
                background: white;
                border-radius: 15px;
                box-shadow: 0 10px 40px rgba(0,0,0,0.1);
                padding: 40px;
                margin-top: 50px;
            }
            .module-card {
                border: none;
                border-radius: 10px;
                transition: transform 0.3s ease, box-shadow 0.3s ease;
                height: 100%;
            }
            .module-card:hover {
                transform: translateY(-5px);
                box-shadow: 0 8px 25px rgba(0,0,0,0.15);
            }
            .module-icon {
                font-size: 3rem;
                margin-bottom: 20px;
            }
            .bg-gradient-primary {
                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            }
            .bg-gradient-success {
                background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%);
            }
            .bg-gradient-warning {
                background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
            }
        </style>
    </head>
    <body>
        <%
            String user ="admin";
            String pass="1234";
            
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            
            if(usuario != null && password != null && usuario.equals(user)
            && password==)
        %>
    </body>

</html>
