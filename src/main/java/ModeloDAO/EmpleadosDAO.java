package ModeloDAO;

import Modelo.Empleados;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpleadosDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Empleados> ListarTodos() {
        ArrayList<Empleados> lista = new ArrayList<>();
        con = Conexion.getConnection();
        try {
            String sql = "select * from empleados";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleados obj = new Empleados();
                obj.setIdEmpleado(rs.getInt("idEmpleado"));
                obj.setApellidos(rs.getString("apellidos"));
                obj.setNombre(rs.getString("nombre"));
                obj.setCargo(rs.getString("cargo"));
                obj.setTratamiento(rs.getString("tratamiento"));
                obj.setFechaNacimiento(rs.getString("fechaNacimiento"));
                obj.setFechaContratacion(rs.getString("fechaContratacion"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setCiudad(rs.getString("ciudad"));
                obj.setRegion(rs.getString("region"));
                obj.setCodPostal(rs.getString("codPostal"));
                obj.setPais(rs.getString("pais"));
                obj.setTelDomicilio(rs.getString("telDomicilio"));
                obj.setExtension(rs.getString("extension"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword(rs.getString("password"));
                lista.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    public int guardar(Empleados obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "insert into empleados values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdEmpleado());
            ps.setString(2, obj.getApellidos());
            ps.setString(3, obj.getNombre());
            ps.setString(4, obj.getCargo());
            ps.setString(5, obj.getTratamiento());
            ps.setString(6, obj.getFechaNacimiento());
            ps.setString(7, obj.getFechaContratacion());
            ps.setString(8, obj.getDireccion());
            ps.setString(9, obj.getCiudad());
            ps.setString(10, obj.getRegion());
            ps.setString(11, obj.getCodPostal());
            ps.setString(12, obj.getPais());
            ps.setString(13, obj.getTelDomicilio());
            ps.setString(14, obj.getExtension());
            ps.setString(15, obj.getEmail());
            ps.setString(16, obj.getPassword());
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public int modificar(Empleados obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "update empleados set apellidos=?, nombre=?, cargo=?, tratamiento=?, fechaNacimiento=?, "
                    + "fechaContratacion=?, direccion=?, ciudad=?, region=?, codPostal=?, pais=?, telDomicilio=?, "
                    + "extension=?, email=?, password=? where idEmpleado=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getApellidos());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getCargo());
            ps.setString(4, obj.getTratamiento());
            ps.setString(5, obj.getFechaNacimiento());
            ps.setString(6, obj.getFechaContratacion());
            ps.setString(7, obj.getDireccion());
            ps.setString(8, obj.getCiudad());
            ps.setString(9, obj.getRegion());
            ps.setString(10, obj.getCodPostal());
            ps.setString(11, obj.getPais());
            ps.setString(12, obj.getTelDomicilio());
            ps.setString(13, obj.getExtension());
            ps.setString(14, obj.getEmail());
            ps.setString(15, obj.getPassword());
            ps.setInt(16, obj.getIdEmpleado());
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public Empleados buscarPorId(int id) {
        Empleados obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from empleados where idEmpleado = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Empleados();
                obj.setIdEmpleado(rs.getInt("idEmpleado"));
                obj.setApellidos(rs.getString("apellidos"));
                obj.setNombre(rs.getString("nombre"));
                obj.setCargo(rs.getString("cargo"));
                obj.setTratamiento(rs.getString("tratamiento"));
                obj.setFechaNacimiento(rs.getString("fechaNacimiento"));
                obj.setFechaContratacion(rs.getString("fechaContratacion"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setCiudad(rs.getString("ciudad"));
                obj.setRegion(rs.getString("region"));
                obj.setCodPostal(rs.getString("codPostal"));
                obj.setPais(rs.getString("pais"));
                obj.setTelDomicilio(rs.getString("telDomicilio"));
                obj.setExtension(rs.getString("extension"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword(rs.getString("password"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return obj;
    }

    public Empleados buscarPorApellido(String apellido) {
        Empleados obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from empleados where apellidos = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, apellido);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Empleados();
                obj.setIdEmpleado(rs.getInt("idEmpleado"));
                obj.setApellidos(rs.getString("apellidos"));
                obj.setNombre(rs.getString("nombre"));
                obj.setCargo(rs.getString("cargo"));
                obj.setTratamiento(rs.getString("tratamiento"));
                obj.setFechaNacimiento(rs.getString("fechaNacimiento"));
                obj.setFechaContratacion(rs.getString("fechaContratacion"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setCiudad(rs.getString("ciudad"));
                obj.setRegion(rs.getString("region"));
                obj.setCodPostal(rs.getString("codPostal"));
                obj.setPais(rs.getString("pais"));
                obj.setTelDomicilio(rs.getString("telDomicilio"));
                obj.setExtension(rs.getString("extension"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword(rs.getString("password"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return obj;
    }

    public int eliminar(int id) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "delete from empleados where idEmpleado = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
