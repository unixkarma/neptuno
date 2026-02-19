<%--
    Document   : nuevoEmpleados
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
        <title>${empleados.idEmpleado == 0 ? 'Nuevo Empleado' : 'Editar Empleado'}</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
        <style>
            body {
                background-color: #f8f9fa;
            }
            .page-header {
                background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%);
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
                border-left: 4px solid #11998e;
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
                    <i class="bi bi-${empleados.idEmpleado == 0 ? 'plus-circle' : 'pencil-square'} me-2"></i>
                    ${empleados.idEmpleado == 0 ? 'Nuevo Empleado' : 'Editar Empleado'}
                </h1>
                <p class="mb-0">Complete la información del empleado</p>
            </div>
        </div>

        <div class="container">
            <div class="form-container">
                <form action="${pageContext.request.contextPath}/EmpleadosControlador" method="post">
                    <input type="hidden" name="idEmpleado" value="${empleados.idEmpleado}">

                    <!-- Información Personal -->
                    <h5 class="section-title">Información Personal</h5>
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="apellidos" class="form-label">
                                <i class="bi bi-person text-primary me-1"></i>Apellidos *
                            </label>
                            <input name="apellidos" type="text" class="form-control" value="${empleados.apellidos}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="nombre" class="form-label">
                                <i class="bi bi-person text-primary me-1"></i>Nombre *
                            </label>
                            <input name="nombre" type="text" class="form-control" value="${empleados.nombre}" required>
                        </div>
                    </div>

                    <!-- Información Laboral -->
                    <h5 class="section-title">Información Laboral</h5>
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="cargo" class="form-label">
                                <i class="bi bi-briefcase text-success me-1"></i>Cargo *
                            </label>
                            <input name="cargo" type="text" class="form-control" value="${empleados.cargo}" required>
                        </div>
                        <div class="col-md-6">
                            <label for="tratamiento" class="form-label">
                                <i class="bi bi-award text-success me-1"></i>Tratamiento
                            </label>
                            <input name="tratamiento" type="text" class="form-control" value="${empleados.tratamiento}">
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="fechaNacimiento" class="form-label">
                                <i class="bi bi-calendar-event text-info me-1"></i>Fecha de Nacimiento
                            </label>
                            <input name="fechaNacimiento" type="date" class="form-control" value="${empleados.fechaNacimiento}">
                        </div>
                        <div class="col-md-6">
                            <label for="fechaContratacion" class="form-label">
                                <i class="bi bi-calendar-check text-info me-1"></i>Fecha de Contratación
                            </label>
                            <input name="fechaContratacion" type="date" class="form-control" value="${empleados.fechaContratacion}">
                        </div>
                    </div>

                    <!-- Dirección -->
                    <h5 class="section-title">Dirección</h5>
                    <div class="mb-3">
                        <label for="direccion" class="form-label">
                            <i class="bi bi-geo-alt text-danger me-1"></i>Dirección
                        </label>
                        <input name="direccion" type="text" class="form-control" value="${empleados.direccion}">
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-4">
                            <label for="ciudad" class="form-label">Ciudad</label>
                            <input name="ciudad" type="text" class="form-control" value="${empleados.ciudad}">
                        </div>
                        <div class="col-md-4">
                            <label for="region" class="form-label">Región</label>
                            <input name="region" type="text" class="form-control" value="${empleados.region}">
                        </div>
                        <div class="col-md-4">
                            <label for="codPostal" class="form-label">Código Postal</label>
                            <input name="codPostal" type="text" class="form-control" value="${empleados.codPostal}">
                        </div>
                    </div>

                    <div class="mb-4">
                        <label for="pais" class="form-label">País</label>
                        <input name="pais" type="text" class="form-control" value="${empleados.pais}">
                    </div>

                    <!-- Contacto -->
                    <h5 class="section-title">Información de Contacto</h5>
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <label for="telDomicilio" class="form-label">
                                <i class="bi bi-telephone text-warning me-1"></i>Teléfono
                            </label>
                            <input name="telDomicilio" type="text" class="form-control" value="${empleados.telDomicilio}">
                        </div>
                        <div class="col-md-6">
                            <label for="extension" class="form-label">
                                <i class="bi bi-hash text-warning me-1"></i>Extensión
                            </label>
                            <input name="extension" type="text" class="form-control" value="${empleados.extension}">
                        </div>
                    </div>

                    <!-- Buttons -->
                    <div class="d-flex justify-content-between pt-3 border-top">
                        <a href="${pageContext.request.contextPath}/EmpleadosControlador?accion=listar"
                           class="btn btn-secondary">
                            <i class="bi bi-arrow-left me-2"></i>Cancelar
                        </a>
                        <button type="submit" name="accion" value="guardar" class="btn btn-success btn-lg">
                            <i class="bi bi-save me-2"></i>Guardar Empleado
                        </button>
                    </div>
                </form>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
