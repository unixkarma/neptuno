/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;


import Modelo.CompaniasEnvios;
import ModeloDAO.CompaniasEnviosDAO;
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

@WebServlet(name = "CompaniasEnviosControlador", urlPatterns = {"/CompaniasEnviosControlador"})
public class CompaniasEnviosControlador extends HttpServlet {

    private CompaniasEnviosDAO dao = new CompaniasEnviosDAO();
    private final String pagListar = "/vista/listarCompaniasEnvios.jsp";
    private final String pagNuevo = "/vista/nuevoCompaniasEnvios.jsp";

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
        request.setAttribute("companias", dao.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("companias", new CompaniasEnvios());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        CompaniasEnvios obj = new CompaniasEnvios();
        String idStr = request.getParameter("idCompania");
        obj.setNombreCompania(request.getParameter("nombreCompania"));
        obj.setTelefono(request.getParameter("telefono"));

        int result = 0;
        if (idStr == null || idStr.isEmpty()){
            result = dao.guardar(obj);
        }else {
            obj.setIdCompania(Integer.parseInt(idStr));
            result = dao.modificar(obj);
        }
        if(result > 0){
            request.getSession().setAttribute("ok", "Registro guardado");
            response.sendRedirect("CompaniasEnviosControlador?accion=listar");
        }else{
            request.getSession().setAttribute("error", "No se pudo guardar el registro");
            request.setAttribute("companias", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("idCompania"));
        CompaniasEnvios obj = dao.buscarPorId(id);
        if(obj != null){
            request.setAttribute("companias", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);

        }else{
            request.getSession().setAttribute("error", "No se encontro el registro");
            response.sendRedirect("CompaniasEnviosControlador?accion=listar");
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("idCompania"));
        request.getSession().setAttribute("error", "Eliminar no está implementado en el DAO");
        response.sendRedirect("CompaniasEnviosControlador?accion=listar");
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
        return "Short description";
    }

}
