<%--
    Document   : nuevoProveedores
    Created on : Jan 29, 2026
    Author     : elliot
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>${proveedores.idProveedor == 0 ? 'Nuevo Proveedor' : 'Editar Proveedor'}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .page-header {
                background: linear-gradient(135deg, #f093fb 0%, #f5576c 100%);
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
                border-left: 4px solid #f093fb;
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
                    <i class="bi bi-${proveedores.idProveedor == 0 ? 'plus-circle' : 'pencil-square'} me-2"></i>
                    ${proveedores.idProveedor == 0 ? 'Nuevo Proveedor' : 'Editar Proveedor'}
                </h1>
                <p class="mb-0">Complete la información del proveedor</p>
            </div>
        </div>

        <div class="container">
            <div class="form-container">
                <form action="${pageContext.request.contextPath}/ProveedoresControlador" method="post">
                    <input type="hidden" name="idProveedor" value="${proveedores.idProveedor}">

                    <!-- Información de la Empresa -->
                    <h5 class="section-title">Información de la Empresa</h5>
                    <div class="mb-3">
                        <label for="nombreCompania" class="form-label">
                            <i class="bi bi-building text-primary me-1"></i>Nombre de Compañía *
                        </label>
                        <input name="nombreCompania" type="text" class="form-control" value="${proveedores.nombreCompania}" required>
                    </div>

                    <!-- Información de Contacto -->
                    <h5 class="section-title">Información de Contacto</h5>
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="nombreContacto" class="form-label">
                                <i class="bi bi-person text-success me-1"></i>Nombre de Contacto
                            </label>
                            <input name="nombreContacto" type="text" class="form-control" value="${proveedores.nombreContacto}">
                        </div>
                        <div class="col-md-6">
                            <label for="cargoContacto" class="form-label">
                                <i class="bi bi-briefcase text-success me-1"></i>Cargo de Contacto
                            </label>
                            <input name="cargoContacto" type="text" class="form-control" value="${proveedores.cargoContacto}">
                        </div>
                    </div>

                    <!-- Dirección -->
                    <h5 class="section-title">Dirección</h5>
                    <div class="mb-3">
                        <label for="direccion" class="form-label">
                            <i class="bi bi-geo-alt text-danger me-1"></i>Dirección
                        </label>
                        <input name="direccion" type="text" class="form-control" value="${proveedores.direccion}">
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-4">
                            <label for="ciudad" class="form-label">Ciudad</label>
                            <input name="ciudad" type="text" class="form-control" value="${proveedores.ciudad}">
                        </div>
                        <div class="col-md-4">
                            <label for="region" class="form-label">Región</label>
                            <input name="region" type="text" class="form-control" value="${proveedores.region}">
                        </div>
                        <div class="col-md-4">
                            <label for="codPostal" class="form-label">Código Postal</label>
                            <input name="codPostal" type="text" class="form-control" value="${proveedores.codPostal}">
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="pais" class="form-label">País</label>
                        <input name="pais" type="text" class="form-control" value="${proveedores.pais}">
                    </div>

                    <!-- Información de Comunicación -->
                    <h5 class="section-title">Información de Comunicación</h5>
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="telefono" class="form-label">
                                <i class="bi bi-telephone text-info me-1"></i>Teléfono
                            </label>
                            <input name="telefono" type="text" class="form-control" value="${proveedores.telefono}">
                        </div>
                        <div class="col-md-6">
                            <label for="fax" class="form-label">
                                <i class="bi bi-printer text-info me-1"></i>Fax
                            </label>
                            <input name="fax" type="text" class="form-control" value="${proveedores.fax}">
                        </div>
                    </div>

                    <!-- Buttons -->
                    <div class="d-flex justify-content-between pt-3 border-top">
                        <a href="${pageContext.request.contextPath}/ProveedoresControlador?accion=listar"
                           class="btn btn-secondary">
                            <i class="bi bi-arrow-left me-2"></i>Cancelar
                        </a>
                        <button type="submit" name="accion" value="guardar" class="btn btn-danger btn-lg">
                            <i class="bi bi-save me-2"></i>Guardar Proveedor
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
