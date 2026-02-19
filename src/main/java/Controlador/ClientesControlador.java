/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;


import Modelo.Clientes;
import ModeloDAO.ClientesDAO;
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

@WebServlet(name = "ClientesControlador", urlPatterns = {"/ClientesControlador"})
public class ClientesControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    
    private ClientesDAO cliDAO = new ClientesDAO();
    private final String pagListar = "/vista/listarClientes.jsp";
    private final String pagNuevo = "/vista/nuevoClientes.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        switch(accion)
        {
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
            default: throw new AssertionError();
        }    
    }
    
    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("clientes", cliDAO.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }   
    
    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("clientes", new Clientes());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Clientes obj = new Clientes();
        obj.setIdCliente(request.getParameter("idCliente"));
        obj.setNombreCompania(request.getParameter("nombreCompania"));
        obj.setNombreContacto(request.getParameter("nombreContacto"));
        obj.setCargoContacto(request.getParameter("cargoContacto"));
        obj.setDireccion(request.getParameter("direccion"));
        obj.setCiudad(request.getParameter("ciudad"));
        obj.setRegion(request.getParameter("region"));
        obj.setCodPostal(request.getParameter("codPostal"));
        obj.setPais(request.getParameter("pais"));
        obj.setTelefono(request.getParameter("telefono"));
        obj.setFax(request.getParameter("fax"));

        // Obtener el tipo de operación del campo hidden
        String operacion = request.getParameter("operacion");

        int result = 0;
        if ("nuevo".equals(operacion)){
            result = cliDAO.guardar(obj);
        }else {
            result = cliDAO.modificar(obj);
        }
        if(result > 0){
            request.getSession().setAttribute("ok", "Registro guardado");
            response.sendRedirect("ClientesControlador?accion=listar");
        }else{
            request.getSession().setAttribute("error", "No se pudo guardar el registro");
            request.setAttribute("clientes", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }
    
    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String id = request.getParameter("idClientes");
        Clientes obj = cliDAO.buscarPorId(id);
        if(obj != null){
            request.setAttribute("clientes", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
            
        }else{
            request.getSession().setAttribute("error", "No se encontro el regustro");
            response.sendRedirect("ClientesControlador?accion=listar");
        }
    }
  
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String id = request.getParameter("idCliente");
        int result = cliDAO.eliminar(id);
        if(result > 0){
            request.getSession().setAttribute("ok", "Se elimino el registro");
            
        }else{
            request.getSession().setAttribute("error", "no se elimino el regustro");
            
        }
        response.sendRedirect("ClientesControlador?accion=listar");
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
