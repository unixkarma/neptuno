package ModeloDAO;

import Modelo.Productos;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductosDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Productos> ListarTodos() {
        ArrayList<Productos> lista = new ArrayList<>();
        con = Conexion.getConnection();
        try {
            String sql = "select * from productos";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Productos obj = new Productos();
                obj.setIdProducto(rs.getInt("idProducto"));
                obj.setNombreProducto(rs.getString("nombreProducto"));
                obj.setIdProveedor(rs.getInt("idProveedor"));
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setCantidadPorUnidad(rs.getString("cantidadPorUnidad"));
                obj.setPrecioUnidad(rs.getDouble("precioUnidad"));
                obj.setUnidadesEnExistencia(rs.getInt("unidadesEnExistencia"));
                obj.setUnidadesEnPedido(rs.getInt("unidadesEnPedido"));
                obj.setNivelNuevoPedido(rs.getInt("nivelNuevoPedido"));
                obj.setSuspendido(rs.getBoolean("suspendido"));
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

    public int guardar(Productos obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "insert into productos values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdProducto());
            ps.setString(2, obj.getNombreProducto());
            ps.setInt(3, obj.getIdProveedor());
            ps.setInt(4, obj.getIdCategoria());
            ps.setString(5, obj.getCantidadPorUnidad());
            ps.setDouble(6, obj.getPrecioUnidad());
            ps.setInt(7, obj.getUnidadesEnExistencia());
            ps.setInt(8, obj.getUnidadesEnPedido());
            ps.setInt(9, obj.getNivelNuevoPedido());
            ps.setBoolean(10, obj.isSuspendido());
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

    public int modificar(Productos obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "update productos set nombreProducto=?, idProveedor=?, idCategoria=?, cantidadPorUnidad=?, "
                    + "precioUnidad=?, unidadesEnExistencia=?, unidadesEnPedido=?, nivelNuevoPedido=?, suspendido=? where idProducto=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreProducto());
            ps.setInt(2, obj.getIdProveedor());
            ps.setInt(3, obj.getIdCategoria());
            ps.setString(4, obj.getCantidadPorUnidad());
            ps.setDouble(5, obj.getPrecioUnidad());
            ps.setInt(6, obj.getUnidadesEnExistencia());
            ps.setInt(7, obj.getUnidadesEnPedido());
            ps.setInt(8, obj.getNivelNuevoPedido());
            ps.setBoolean(9, obj.isSuspendido());
            ps.setInt(10, obj.getIdProducto());
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

    public Productos buscarPorId(int id) {
        Productos obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from productos where idProducto = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Productos();
                obj.setIdProducto(rs.getInt("idProducto"));
                obj.setNombreProducto(rs.getString("nombreProducto"));
                obj.setIdProveedor(rs.getInt("idProveedor"));
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setCantidadPorUnidad(rs.getString("cantidadPorUnidad"));
                obj.setPrecioUnidad(rs.getDouble("precioUnidad"));
                obj.setUnidadesEnExistencia(rs.getInt("unidadesEnExistencia"));
                obj.setUnidadesEnPedido(rs.getInt("unidadesEnPedido"));
                obj.setNivelNuevoPedido(rs.getInt("nivelNuevoPedido"));
                obj.setSuspendido(rs.getBoolean("suspendido"));
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

    public Productos buscarPorNombre(String nombre) {
        Productos obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from productos where nombreProducto = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Productos();
                obj.setIdProducto(rs.getInt("idProducto"));
                obj.setNombreProducto(rs.getString("nombreProducto"));
                obj.setIdProveedor(rs.getInt("idProveedor"));
                obj.setIdCategoria(rs.getInt("idCategoria"));
                obj.setCantidadPorUnidad(rs.getString("cantidadPorUnidad"));
                obj.setPrecioUnidad(rs.getDouble("precioUnidad"));
                obj.setUnidadesEnExistencia(rs.getInt("unidadesEnExistencia"));
                obj.setUnidadesEnPedido(rs.getInt("unidadesEnPedido"));
                obj.setNivelNuevoPedido(rs.getInt("nivelNuevoPedido"));
                obj.setSuspendido(rs.getBoolean("suspendido"));
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
