package Controlador;

import Modelo.Empleados;
import ModeloDAO.EmpleadosDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginDBControlador", urlPatterns = {"/LoginDBControlador"})
public class LoginDBControlador extends HttpServlet {

    private EmpleadosDAO empDAO = new EmpleadosDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Empleados empleado = empDAO.buscarPorLogin(login, password);

        if (empleado != null) {
            request.getSession().setAttribute("empleadoLogueado", empleado);
            response.sendRedirect(request.getContextPath() + "/EmpleadosControlador?accion=listar");
        } else {
            response.sendRedirect(request.getContextPath() + "/loginDB.jsp?error=1");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/loginDB.jsp");
    }
}
