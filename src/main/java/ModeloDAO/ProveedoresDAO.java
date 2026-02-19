package ModeloDAO;

import Modelo.Proveedores;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProveedoresDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Proveedores> ListarTodos() {
        ArrayList<Proveedores> lista = new ArrayList<>();
        con = Conexion.getConnection();
        try {
            String sql = "select * from proveedores";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedores obj = new Proveedores();
                obj.setIdProveedor(rs.getInt("idProveedor"));
                obj.setNombreCompania(rs.getString("nombreCompania"));
                obj.setNombreContacto(rs.getString("nombreContacto"));
                obj.setCargoContacto(rs.getString("cargoContacto"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setCiudad(rs.getString("ciudad"));
                obj.setRegion(rs.getString("region"));
                obj.setCodPostal(rs.getString("codPostal"));
                obj.setPais(rs.getString("pais"));
                obj.setTelefono(rs.getString("telefono"));
                obj.setFax(rs.getString("fax"));
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

    public int guardar(Proveedores obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "insert into proveedores values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, obj.getIdProveedor());
            ps.setString(2, obj.getNombreCompania());
            ps.setString(3, obj.getNombreContacto());
            ps.setString(4, obj.getCargoContacto());
            ps.setString(5, obj.getDireccion());
            ps.setString(6, obj.getCiudad());
            ps.setString(7, obj.getRegion());
            ps.setString(8, obj.getCodPostal());
            ps.setString(9, obj.getPais());
            ps.setString(10, obj.getTelefono());
            ps.setString(11, obj.getFax());
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

    public int modificar(Proveedores obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "update proveedores set nombreCompania=?, nombreContacto=?, cargoContacto=?, direccion=?, "
                    + "ciudad=?, region=?, codPostal=?, pais=?, telefono=?, fax=? where idProveedor=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getNombreCompania());
            ps.setString(2, obj.getNombreContacto());
            ps.setString(3, obj.getCargoContacto());
            ps.setString(4, obj.getDireccion());
            ps.setString(5, obj.getCiudad());
            ps.setString(6, obj.getRegion());
            ps.setString(7, obj.getCodPostal());
            ps.setString(8, obj.getPais());
            ps.setString(9, obj.getTelefono());
            ps.setString(10, obj.getFax());
            ps.setInt(11, obj.getIdProveedor());
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

    public Proveedores buscarPorId(int id) {
        Proveedores obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from proveedores where idProveedor = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Proveedores();
                obj.setIdProveedor(rs.getInt("idProveedor"));
                obj.setNombreCompania(rs.getString("nombreCompania"));
                obj.setNombreContacto(rs.getString("nombreContacto"));
                obj.setCargoContacto(rs.getString("cargoContacto"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setCiudad(rs.getString("ciudad"));
                obj.setRegion(rs.getString("region"));
                obj.setCodPostal(rs.getString("codPostal"));
                obj.setPais(rs.getString("pais"));
                obj.setTelefono(rs.getString("telefono"));
                obj.setFax(rs.getString("fax"));
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

    public Proveedores buscarPorNombreCompania(String compania) {
        Proveedores obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from proveedores where nombreCompania = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, compania);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Proveedores();
                obj.setIdProveedor(rs.getInt("idProveedor"));
                obj.setNombreCompania(rs.getString("nombreCompania"));
                obj.setNombreContacto(rs.getString("nombreContacto"));
                obj.setCargoContacto(rs.getString("cargoContacto"));
                obj.setDireccion(rs.getString("direccion"));
                obj.setCiudad(rs.getString("ciudad"));
                obj.setRegion(rs.getString("region"));
                obj.setCodPostal(rs.getString("codPostal"));
                obj.setPais(rs.getString("pais"));
                obj.setTelefono(rs.getString("telefono"));
                obj.setFax(rs.getString("fax"));
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

    public int eliminar(int id) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "delete from proveedores where idProveedor = ?";
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
