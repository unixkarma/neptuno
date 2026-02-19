/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;


import Modelo.Productos;
import ModeloDAO.ProductosDAO;
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

@WebServlet(name = "ProductosControlador", urlPatterns = {"/ProductosControlador"})
public class ProductosControlador extends HttpServlet {

    private ProductosDAO dao = new ProductosDAO();
    private final String pagListar = "/vista/listarProductos.jsp";
    private final String pagNuevo = "/vista/nuevoProductos.jsp";

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
        request.setAttribute("productos", dao.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }

    protected void nuevo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("productos", new Productos());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        Productos obj = new Productos();
        String idStr = request.getParameter("idProducto");
        obj.setNombreProducto(request.getParameter("nombreProducto"));
        obj.setIdProveedor(Integer.parseInt(request.getParameter("idProveedor")));
        obj.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
        obj.setCantidadPorUnidad(request.getParameter("cantidadPorUnidad"));
        obj.setPrecioUnidad(Double.parseDouble(request.getParameter("precioUnidad")));
        obj.setUnidadesEnExistencia(Integer.parseInt(request.getParameter("unidadesEnExistencia")));
        obj.setUnidadesEnPedido(Integer.parseInt(request.getParameter("unidadesEnPedido")));
        obj.setNivelNuevoPedido(Integer.parseInt(request.getParameter("nivelNuevoPedido")));
        obj.setSuspendido(request.getParameter("suspendido") != null);

        int result = 0;
        if (idStr == null || idStr.isEmpty()){
            result = dao.guardar(obj);
        }else {
            obj.setIdProducto(Integer.parseInt(idStr));
            result = dao.modificar(obj);
        }
        if(result > 0){
            request.getSession().setAttribute("ok", "Registro guardado");
            response.sendRedirect("ProductosControlador?accion=listar");
        }else{
            request.getSession().setAttribute("error", "No se pudo guardar el registro");
            request.setAttribute("productos", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("idProducto"));
        Productos obj = dao.buscarPorId(id);
        if(obj != null){
            request.setAttribute("productos", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);

        }else{
            request.getSession().setAttribute("error", "No se encontro el registro");
            response.sendRedirect("ProductosControlador?accion=listar");
        }
    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("idProducto"));
        request.getSession().setAttribute("error", "Eliminar no está implementado en el DAO");
        response.sendRedirect("ProductosControlador?accion=listar");
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
