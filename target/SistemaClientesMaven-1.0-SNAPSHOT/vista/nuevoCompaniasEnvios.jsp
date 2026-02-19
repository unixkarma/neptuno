<%--
    Document   : nuevoCompaniasEnvios
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
        <title>${empty companias.idCompania || companias.idCompania == 0 ? 'Nueva Compañía de Envíos' : 'Editar Compañía de Envíos'}</title>
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
            .form-container {
                background: white;
                border-radius: 10px;
                padding: 30px;
                box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            }
            .section-title {
                border-left: 4px solid #667eea;
                padding-left: 15px;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>
        <!-- Header -->
        <div class="page-header">
            <div class="container">
                <h1>
                    <i class="bi bi-${empty companias.idCompania || companias.idCompania == 0 ? 'plus-circle' : 'pencil-square'} me-2"></i>
                    ${empty companias.idCompania || companias.idCompania == 0 ? 'Nueva Compañía de Envíos' : 'Editar Compañía de Envíos'}
                </h1>
                <p class="mb-0">Complete la información de la compañía de envíos</p>
            </div>
        </div>

        <div class="container">
            <div class="form-container">
                <form action="${pageContext.request.contextPath}/CompaniasEnviosControlador" method="post">
                    <!-- Información Básica -->
                    <h5 class="section-title">Información de la Compañía</h5>
                    <div class="row mb-4">
                        <div class="col-md-4">
                            <label for="idCompania" class="form-label">
                                <i class="bi bi-key-fill text-primary me-1"></i>ID Compañía
                            </label>
                            <input name="idCompania" type="number" class="form-control" value="${companias.idCompania == 0 ? '' : companias.idCompania}"
                                   ${empty companias.idCompania || companias.idCompania == 0 ? 'required' : 'readonly'}>
                        </div>
                        <div class="col-md-8">
                            <label for="nombreCompania" class="form-label">
                                <i class="bi bi-building text-primary me-1"></i>Nombre de Compañía *
                            </label>
                            <input name="nombreCompania" type="text" class="form-control" value="${companias.nombreCompania}" required>
                        </div>
                    </div>

                    <!-- Información de Contacto -->
                    <h5 class="section-title">Información de Contacto</h5>
                    <div class="mb-4">
                        <label for="telefono" class="form-label">
                            <i class="bi bi-telephone text-info me-1"></i>Teléfono
                        </label>
                        <input name="telefono" type="text" class="form-control" value="${companias.telefono}">
                    </div>

                    <!-- Buttons -->
                    <div class="d-flex justify-content-between pt-3 border-top">
                        <a href="${pageContext.request.contextPath}/CompaniasEnviosControlador?accion=listar"
                           class="btn btn-secondary">
                            <i class="bi bi-arrow-left me-2"></i>Cancelar
                        </a>
                        <button type="submit" name="accion" value="guardar" class="btn btn-primary btn-lg">
                            <i class="bi bi-save me-2"></i>Guardar Compañía
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
