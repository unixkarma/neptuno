<%--
    Document   : loginDB
    Created on : Feb 26, 2026
    Author     : elliot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Acceso de Clientes</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <style>
            body {
                background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%);
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
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-5">
                    <div class="main-card">
                        <div class="text-center mb-4">
                            <i class="bi bi-person-circle" style="font-size: 4rem; color: #11998e;"></i>
                            <h2 class="mt-3">Acceso de Clientes</h2>
                            <p class="text-muted">Ingrese su login y contraseña</p>
                        </div>

                        <% if(request.getParameter("error") != null){ %>
                            <div class="alert alert-danger">
                                <i class="bi bi-exclamation-triangle-fill me-2"></i>
                                Login o contraseña incorrectos
                            </div>
                        <% } %>

                        <% if(request.getParameter("logout") != null){ %>
                            <div class="alert alert-info">
                                <i class="bi bi-check-circle-fill me-2"></i>
                                Sesión cerrada correctamente
                            </div>
                        <% } %>

                        <form action="${pageContext.request.contextPath}/LoginDBControlador" method="post">
                            <div class="mb-3">
                                <label for="login" class="form-label">
                                    <i class="bi bi-person-fill me-2"></i>Login
                                </label>
                                <input type="text" class="form-control" id="login" name="login" required>
                            </div>
                            <div class="mb-3">
                                <label for="password" class="form-label">
                                    <i class="bi bi-lock-fill me-2"></i>Contraseña
                                </label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                            <button type="submit" class="btn btn-success w-100 btn-lg">
                                <i class="bi bi-box-arrow-in-right me-2"></i>Ingresar
                            </button>
                        </form>

                        <div class="mt-3 text-center">
                            <a href="${pageContext.request.contextPath}/" class="text-muted small">
                                <i class="bi bi-arrow-left me-1"></i>Volver al inicio
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
