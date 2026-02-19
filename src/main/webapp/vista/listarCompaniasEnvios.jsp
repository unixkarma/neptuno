<%--
    Document   : listarCompaniasEnvios
    Created on : Feb 5, 2026
    Author     : elliot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Lista de Compañías de Envíos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .page-header {
                background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                color: white;
                padding: 30px 0;
                margin-bottom: 30px;
                box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            }
            .table-container {
                background: white;
                border-radius: 10px;
                padding: 25px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <div class="page-header">
            <div class="container">
                <div class="d-flex justify-content-between align-items-center">
                    <div>
                        <h1><i class="bi bi-truck me-2"></i>Compañías de Envíos</h1>
                        <p class="mb-0">Gestión de compañías de envíos del sistema</p>
                    </div>
                    <a href="${pageContext.request.contextPath}/" class="btn btn-light">
                        <i class="bi bi-house-fill me-2"></i>Inicio
                    </a>
                </div>
            </div>
        </div>

        <div class="container">
            <!-- Alerts -->
            <c:if test="${sessionScope.ok != null}">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <i class="bi bi-check-circle-fill me-2"></i>${sessionScope.ok}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
                <c:remove var="ok" scope="session"/>
            </c:if>

            <c:if test="${sessionScope.error != null}">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <i class="bi bi-exclamation-triangle-fill me-2"></i>${sessionScope.error}
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
                <c:remove var="error" scope="session"/>
            </c:if>

            <!-- Action Buttons -->
            <div class="mb-3">
                <a href="${pageContext.request.contextPath}/CompaniasEnviosControlador?accion=nuevo"
                   class="btn btn-primary btn-lg">
                    <i class="bi bi-plus-circle me-2"></i>Nueva Compañía de Envíos
                </a>
            </div>

            <!-- Table -->
            <div class="table-container">
                <div class="table-responsive">
                    <table class="table table-hover align-middle">
                        <thead class="table-dark">
                            <tr>
                                <th><i class="bi bi-hash me-1"></i>ID</th>
                                <th><i class="bi bi-building me-1"></i>Nombre Compañía</th>
                                <th><i class="bi bi-telephone me-1"></i>Teléfono</th>
                                <th class="text-center"><i class="bi bi-gear me-1"></i>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${companias}" var="item">
                                <tr>
                                    <td><strong>${item.idCompania}</strong></td>
                                    <td>${item.nombreCompania}</td>
                                    <td><i class="bi bi-telephone-fill text-success me-1"></i>${item.telefono}</td>
                                    <td class="text-center">
                                        <a href="${pageContext.request.contextPath}/CompaniasEnviosControlador?accion=editar&idCompania=${item.idCompania}"
                                           class="btn btn-warning btn-sm me-1" title="Editar">
                                            <i class="bi bi-pencil-fill"></i>
                                        </a>
                                        <a href="${pageContext.request.contextPath}/CompaniasEnviosControlador?accion=eliminar&idCompania=${item.idCompania}"
                                           class="btn btn-danger btn-sm" title="Eliminar"
                                           onclick="return confirm('¿Está seguro de eliminar esta compañía?')">
                                            <i class="bi bi-trash-fill"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
