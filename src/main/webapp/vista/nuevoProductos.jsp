<%--
    Document   : nuevoProductos
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
        <title>${empty productos.idProducto || productos.idProducto == 0 ? 'Nuevo Producto' : 'Editar Producto'}</title>
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
                    <i class="bi bi-${empty productos.idProducto || productos.idProducto == 0 ? 'plus-circle' : 'pencil-square'} me-2"></i>
                    ${empty productos.idProducto || productos.idProducto == 0 ? 'Nuevo Producto' : 'Editar Producto'}
                </h1>
                <p class="mb-0">Complete la información del producto</p>
            </div>
        </div>

        <div class="container">
            <div class="form-container">
                <form action="${pageContext.request.contextPath}/ProductosControlador" method="post">
                    <!-- Información Básica -->
                    <h5 class="section-title">Información Básica</h5>
                    <div class="row mb-4">
                        <div class="col-md-3">
                            <label for="idProducto" class="form-label">
                                <i class="bi bi-key-fill text-primary me-1"></i>ID Producto
                            </label>
                            <input name="idProducto" type="number" class="form-control" value="${productos.idProducto == 0 ? '' : productos.idProducto}"
                                   ${empty productos.idProducto || productos.idProducto == 0 ? 'required' : 'readonly'}>
                        </div>
                        <div class="col-md-9">
                            <label for="nombreProducto" class="form-label">
                                <i class="bi bi-box text-primary me-1"></i>Nombre del Producto *
                            </label>
                            <input name="nombreProducto" type="text" class="form-control" value="${productos.nombreProducto}" required>
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="idProveedor" class="form-label">
                                <i class="bi bi-truck text-success me-1"></i>ID Proveedor *
                            </label>
                            <input name="idProveedor" type="number" class="form-control" value="${productos.idProveedor == 0 ? '' : productos.idProveedor}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="idCategoria" class="form-label">
                                <i class="bi bi-tag text-success me-1"></i>ID Categoría *
                            </label>
                            <input name="idCategoria" type="number" class="form-control" value="${productos.idCategoria == 0 ? '' : productos.idCategoria}" required>
                        </div>
                    </div>

                    <!-- Información de Inventario -->
                    <h5 class="section-title">Información de Inventario</h5>
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="cantidadPorUnidad" class="form-label">
                                <i class="bi bi-box2 text-warning me-1"></i>Cantidad por Unidad
                            </label>
                            <input name="cantidadPorUnidad" type="text" class="form-control" value="${productos.cantidadPorUnidad}">
                        </div>
                        <div class="col-md-6">
                            <label for="precioUnidad" class="form-label">
                                <i class="bi bi-cash text-warning me-1"></i>Precio por Unidad *
                            </label>
                            <input name="precioUnidad" type="number" step="0.01" class="form-control" value="${productos.precioUnidad}" required>
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-4">
                            <label for="unidadesEnExistencia" class="form-label">
                                <i class="bi bi-archive text-info me-1"></i>Unidades en Existencia *
                            </label>
                            <input name="unidadesEnExistencia" type="number" class="form-control" value="${productos.unidadesEnExistencia}" required>
                        </div>
                        <div class="col-md-4">
                            <label for="unidadesEnPedido" class="form-label">
                                <i class="bi bi-cart text-info me-1"></i>Unidades en Pedido *
                            </label>
                            <input name="unidadesEnPedido" type="number" class="form-control" value="${productos.unidadesEnPedido}" required>
                        </div>
                        <div class="col-md-4">
                            <label for="nivelNuevoPedido" class="form-label">
                                <i class="bi bi-arrow-repeat text-info me-1"></i>Nivel Nuevo Pedido *
                            </label>
                            <input name="nivelNuevoPedido" type="number" class="form-control" value="${productos.nivelNuevoPedido}" required>
                        </div>
                    </div>

                    <!-- Estado -->
                    <h5 class="section-title">Estado del Producto</h5>
                    <div class="mb-4">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox" name="suspendido" id="suspendido"
                                   ${productos.suspendido ? 'checked' : ''}>
                            <label class="form-check-label" for="suspendido">
                                <i class="bi bi-pause-circle text-danger me-1"></i>Producto Suspendido
                            </label>
                        </div>
                    </div>

                    <!-- Buttons -->
                    <div class="d-flex justify-content-between pt-3 border-top">
                        <a href="${pageContext.request.contextPath}/ProductosControlador?accion=listar"
                           class="btn btn-secondary">
                            <i class="bi bi-arrow-left me-2"></i>Cancelar
                        </a>
                        <button type="submit" name="accion" value="guardar" class="btn btn-primary btn-lg">
                            <i class="bi bi-save me-2"></i>Guardar Producto
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
