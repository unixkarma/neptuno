package ModeloDAO;

import Modelo.CompaniasEnvios;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CompaniasEnviosDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<CompaniasEnvios> ListarTodos() {
        ArrayList<CompaniasEnvios> lista = new ArrayList<>();
        con = Conexion.getConnection();
        try {
            String sql = "select * from companiasEnvios";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CompaniasEnvios obj = new CompaniasEnvios();
                obj.setIdCompania(rs.getInt("idCompania"));
                obj.setNombreCompania(rs.getString("nombreCompania"));
                obj.setTelefono(rs.getString("telefono"));
                lista.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    public int guardar(CompaniasEnvios obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "insert into companiasEnvios values(?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdCompania());
            ps.setString(2, obj.getNombreCompania());
            ps.setString(3, obj.getTelefono());
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

    public int modificar(CompaniasEnvios obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "update companiasEnvios set nombreCompania=?, telefono=? where idCompania=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreCompania());
            ps.setString(2, obj.getTelefono());
            ps.setInt(3, obj.getIdCompania());
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public CompaniasEnvios buscarPorId(int id) {
        CompaniasEnvios obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from companiasEnvios where idCompania = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new CompaniasEnvios();
                obj.setIdCompania(rs.getInt("idCompania"));
                obj.setNombreCompania(rs.getString("nombreCompania"));
                obj.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return obj;
    }

    public CompaniasEnvios buscarPorNombre(String nombre) {
        CompaniasEnvios obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from companiasEnvios where nombreCompania = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new CompaniasEnvios();
                obj.setIdCompania(rs.getInt("idCompania"));
                obj.setNombreCompania(rs.getString("nombreCompania"));
                obj.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) con.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return obj;
    }
}
