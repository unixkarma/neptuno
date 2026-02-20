/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Empleados;
import ModeloDAO.EmpleadosDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

/**
 *
 * @author elliot
 */
@WebServlet(name = "EmpleadosControlador", urlPatterns = {"/EmpleadosControlador"})
public class EmpleadosControlador extends HttpServlet {

    private EmpleadosDAO empDAO = new EmpleadosDAO();
    private final String pagListar = "/vista/listarEmpleados.jsp";
    private final String pagNuevo = "/vista/nuevoEmpleados.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "listar":
                listar(request, response);
                break;
            case "nuevo":
                nuevo(request, response);
                break;
            case "guardar":
                guardar(request, response);
                break;
            case "editar":
                editar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empleados", empDAO.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("empleados", new Empleados());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleados obj = new Empleados();

        String idParam = request.getParameter("idEmpleado");
        if (idParam != null && !idParam.isEmpty()) {
            obj.setIdEmpleado(Integer.parseInt(idParam));
        }
        obj.setApellidos(request.getParameter("apellidos"));
        obj.setNombre(request.getParameter("nombre"));
        obj.setCargo(request.getParameter("cargo"));
        obj.setTratamiento(request.getParameter("tratamiento"));
        obj.setFechaNacimiento(request.getParameter("fechaNacimiento"));
        obj.setFechaContratacion(request.getParameter("fechaContratacion"));
        obj.setDireccion(request.getParameter("direccion"));
        obj.setCiudad(request.getParameter("ciudad"));
        obj.setRegion(request.getParameter("region"));
        obj.setCodPostal(request.getParameter("codPostal"));
        obj.setPais(request.getParameter("pais"));
        obj.setTelDomicilio(request.getParameter("telDomicilio"));
        obj.setExtension(request.getParameter("extension"));
        obj.setEmail(request.getParameter("email"));
        obj.setPassword(request.getParameter("password"));

        int result = 0;
        if (obj.getIdEmpleado() == 0) {
            result = empDAO.guardar(obj);
        } else {
            result = empDAO.modificar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("ok", "Registro guardado");
            response.sendRedirect("EmpleadosControlador?accion=listar");
        } else {
            request.getSession().setAttribute("error", "No se pudo guardar el registro");
            request.setAttribute("empleados", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idEmpleado"));
        Empleados obj = empDAO.buscarPorId(id);
        if (obj != null) {
            request.setAttribute("empleados", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "No se encontro el registro");
            response.sendRedirect("EmpleadosControlador?accion=listar");
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idEmpleado"));
        int result = empDAO.eliminar(id);
        if (result > 0) {
            request.getSession().setAttribute("ok", "Se elimino el registro");
        } else {
            request.getSession().setAttribute("error", "No se elimino el registro");
        }
        response.sendRedirect("EmpleadosControlador?accion=listar");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Controlador de Empleados";
    }
}
