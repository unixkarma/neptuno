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
            String user = "admin";
            String pass = "1234";

            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");

            // Si ya está autenticado, ir a clientes
            if(session.getAttribute("usuario") != null){
                response.sendRedirect("ClientesControlador?accion=listar");
                return;
            }

            // Si viene del formulario de login
            if(usuario != null && password != null){
                if(usuario.equals(user) && password.equals(pass)){
                    session.setAttribute("usuario", usuario);
                    response.sendRedirect("ClientesControlador?accion=listar");
                    return;
                } else {
                    // Credenciales incorrectas
                    request.setAttribute("error", "Usuario o contraseña incorrectos");
                }
            }
        %>

        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="main-card">
                        <div class="text-center mb-4">
                            <i class="bi bi-shield-lock-fill" style="font-size: 4rem; color: #667eea;"></i>
                            <h1 class="mt-3">Sistema de Clientes</h1>
                            <p class="text-muted">Ingrese sus credenciales</p>
                        </div>

                        <% if(request.getAttribute("error") != null){ %>
                            <div class="alert alert-danger">
                                <i class="bi bi-exclamation-triangle-fill me-2"></i>
                                <%= request.getAttribute("error") %>
                            </div>
                        <% } %>

                        <% if(request.getParameter("error") != null){ %>
                            <div class="alert alert-danger">
                                <i class="bi bi-exclamation-triangle-fill me-2"></i>
                                Usuario o contraseña incorrectos
                            </div>
                        <% } %>

                        <form action="index.jsp" method="post">
                            <div class="mb-3">
                                <label for="usuario" class="form-label">
                                    <i class="bi bi-person-fill me-2"></i>Usuario
                                </label>
                                <input type="text" class="form-control" id="usuario"
                                       name="usuario" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">
                                    <i class="bi bi-lock-fill me-2"></i>Contraseña
                                </label>
                                <input type="password" class="form-control" id="password"
                                       name="password" required>
                            </div>
                            <button type="submit" class="btn btn-primary w-100 btn-lg">
                                <i class="bi bi-box-arrow-in-right me-2"></i>Ingresar
                            </button>
                        </form>

                        <div class="mt-4 text-center text-muted">
                            <small>Usuario: admin | Contraseña: 1234</small>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>

</html>
