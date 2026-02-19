<%--
    Document   : nuevoCategorias
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
        <title>${empty categorias.idCategoria || categorias.idCategoria == 0 ? 'Nueva Categoría' : 'Editar Categoría'}</title>
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
                    <i class="bi bi-${empty categorias.idCategoria || categorias.idCategoria == 0 ? 'plus-circle' : 'pencil-square'} me-2"></i>
                    ${empty categorias.idCategoria || categorias.idCategoria == 0 ? 'Nueva Categoría' : 'Editar Categoría'}
                </h1>
                <p class="mb-0">Complete la información de la categoría</p>
            </div>
        </div>

        <div class="container">
            <div class="form-container">
                <form action="${pageContext.request.contextPath}/CategoriasControlador" method="post">
                    <!-- Información Básica -->
                    <h5 class="section-title">Información de la Categoría</h5>
                    <div class="row mb-4">
                        <div class="col-md-4">
                            <label for="idCategoria" class="form-label">
                                <i class="bi bi-key-fill text-primary me-1"></i>ID Categoría
                            </label>
                            <input name="idCategoria" type="number" class="form-control" value="${categorias.idCategoria == 0 ? '' : categorias.idCategoria}"
                                   ${empty categorias.idCategoria || categorias.idCategoria == 0 ? 'required' : 'readonly'}>
                        </div>
                        <div class="col-md-8">
                            <label for="nombreCategoria" class="form-label">
                                <i class="bi bi-tag text-primary me-1"></i>Nombre de Categoría *
                            </label>
                            <input name="nombreCategoria" type="text" class="form-control" value="${categorias.nombreCategoria}" required>
                        </div>
                    </div>

                    <!-- Descripción -->
                    <h5 class="section-title">Descripción</h5>
                    <div class="mb-4">
                        <label for="descripcion" class="form-label">
                            <i class="bi bi-file-text text-info me-1"></i>Descripción
                        </label>
                        <textarea name="descripcion" class="form-control" rows="4">${categorias.descripcion}</textarea>
                    </div>

                    <!-- Buttons -->
                    <div class="d-flex justify-content-between pt-3 border-top">
                        <a href="${pageContext.request.contextPath}/CategoriasControlador?accion=listar"
                           class="btn btn-secondary">
                            <i class="bi bi-arrow-left me-2"></i>Cancelar
                        </a>
                        <button type="submit" name="accion" value="guardar" class="btn btn-primary btn-lg">
                            <i class="bi bi-save me-2"></i>Guardar Categoría
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
