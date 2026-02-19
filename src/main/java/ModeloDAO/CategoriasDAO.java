package ModeloDAO;

import Modelo.Categorias;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriasDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Categorias> ListarTodos() {
        ArrayList<Categorias> lista = new ArrayList<>();
        con = Conexion.getConnection();
        try {
            String sql = "select * from categorias";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Categorias obj = new Categorias();
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setNombreCategoria(rs.getString("nombreCategoria"));
                obj.setDescripcion(rs.getString("descripcion"));
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

    public int guardar(Categorias obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "insert into categorias values(?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdCategoria());
            ps.setString(2, obj.getNombreCategoria());
            ps.setString(3, obj.getDescripcion());
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

    public int modificar(Categorias obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "update categorias set nombreCategoria=?, descripcion=? where idCategoria=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreCategoria());
            ps.setString(2, obj.getDescripcion());
            ps.setInt(3, obj.getIdCategoria());
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

    public Categorias buscarPorId(int id) {
        Categorias obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from categorias where idCategoria = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Categorias();
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setNombreCategoria(rs.getString("nombreCategoria"));
                obj.setDescripcion(rs.getString("descripcion"));
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

    public Categorias buscarPorNombre(String nombre) {
        Categorias obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from categorias where nombreCategoria = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Categorias();
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setNombreCategoria(rs.getString("nombreCategoria"));
                obj.setDescripcion(rs.getString("descripcion"));
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
