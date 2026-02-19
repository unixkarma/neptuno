package Controlador;                                                      
                                                                            
import Modelo.Proveedores;                                                
import ModeloDAO.ProveedoresDAO;                                          
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;                            
                                                                            
@WebServlet(name = "ProveedoresControlador", urlPatterns =                
{"/ProveedoresControlador"})                                              
public class ProveedoresControlador extends HttpServlet {                 
                                                                            
    private ProveedoresDAO provDAO = new ProveedoresDAO();                
    private final String pagListar = "/vista/listarProveedores.jsp";     
    private final String pagNuevo = "/vista/nuevoProveedores.jsp";        
                                                                            
    protected void processRequest(HttpServletRequest request,             
  HttpServletResponse response)                                             
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
                                                                            
    protected void listar(HttpServletRequest request, HttpServletResponse 
  response)                                                                 
            throws ServletException, IOException {                        
        request.setAttribute("proveedores", provDAO.ListarTodos());       
        request.getRequestDispatcher(pagListar).forward(request,          
  response);                                                                
    }                                                                     
                                                                            
    protected void nuevo(HttpServletRequest request, HttpServletResponse  
  response)                                                                 
            throws ServletException, IOException {                        
        request.setAttribute("proveedores", new Proveedores());            
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }                                                                     
                                                                            
    protected void guardar(HttpServletRequest request, HttpServletResponse
   response)                                                                
            throws ServletException, IOException {                        
        Proveedores obj = new Proveedores();                              
                                                                            
        String idParam = request.getParameter("idProveedor");             
        if (idParam != null && !idParam.isEmpty()) {                      
            obj.setIdProveedor(Integer.parseInt(idParam));                
        }                                                                 
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
                                                                            
        int result = 0;                                                   
        if (obj.getIdProveedor() == 0) {                                  
            result = provDAO.guardar(obj);                                
        } else {                                                          
            result = provDAO.modificar(obj);                              
        }                                                                 
                                                                            
        if (result > 0) {                                                 
            request.getSession().setAttribute("ok", "Registro guardado"); 
            response.sendRedirect("ProveedoresControlador?accion=listar");
        } else {                                                          
            request.getSession().setAttribute("error", "No se pudo guardar el registro");                                                           
            request.setAttribute("proveedores", obj);                     
            request.getRequestDispatcher(pagNuevo).forward(request,       
  response);                                                                
        }                                                                 
    }                                                                     
                                                                            
    protected void editar(HttpServletRequest request, HttpServletResponse 
  response)                                                                 
            throws ServletException, IOException {                        
        int id = Integer.parseInt(request.getParameter("idProveedor"));   
        Proveedores obj = provDAO.buscarPorId(id);                        
        if (obj != null) {                                                
            request.setAttribute("proveedores", obj);                     
            request.getRequestDispatcher(pagNuevo).forward(request,       
  response);                                                                
        } else {                                                          
            request.getSession().setAttribute("error", "No se encontro el registro");                                                               
            response.sendRedirect("ProveedoresControlador?accion=listar");
        }                                                                 
    }                                                                     
                                                                            
    @Override                                                             
    protected void doGet(HttpServletRequest request, HttpServletResponse  
  response)                                                                 
            throws ServletException, IOException {                        
        processRequest(request, response);                                
    }                                                                     
                                                                            
    @Override                                                             
    protected void doPost(HttpServletRequest request, HttpServletResponse 
  response)                                                                 
            throws ServletException, IOException {                        
        processRequest(request, response);                                
    }                                                                     
                                                                            
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProveedor"));
        int result = provDAO.eliminar(id);
        if (result > 0) {
            request.getSession().setAttribute("ok", "Se elimino el registro");
        } else {
            request.getSession().setAttribute("error", "No se elimino el registro");
        }
        response.sendRedirect("ProveedoresControlador?accion=listar");
    }

    @Override
    public String getServletInfo() {
        return "Controlador de Proveedores";
    }
}      