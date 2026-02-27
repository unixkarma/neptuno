package ModeloDAO;

import Modelo.Clientes;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ClientesDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public ArrayList<Clientes> ListarTodos() {
        ArrayList<Clientes> lista = new ArrayList<>();
        con = Conexion.getConnection();
        try {
            String sql = "select * from clientes";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setIdCliente(rs.getString("idCliente"));
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
                obj.setJefe(rs.getString("jefe"));
                obj.setLogin(rs.getString("login"));
                obj.setPassword(rs.getString("password"));
                lista.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    public int guardar(Clientes obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "insert into clientes values(? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, obj.getIdCliente());
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
            ps.setString(12, obj.getJefe());
            ps.setString(13, obj.getLogin());
            ps.setString(14, obj.getPassword());
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public int modificar(Clientes obj) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "update clientes set nombreCompania = ? , nombreContacto = ? , cargoContacto = ?"
                    + " , direccion = ? , ciudad = ? , region = ? , codPostal = ? , pais = ? , telefono = ?"
                    + " , fax = ? , jefe = ? , login = ? , password = ? where idCliente = ?";
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
            ps.setString(11, obj.getJefe());
            ps.setString(12, obj.getLogin());
            ps.setString(13, obj.getPassword());
            ps.setString(14, obj.getIdCliente());
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public Clientes buscarPorId(String id) {
        Clientes obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from clientes where idCliente = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new Clientes();
                obj.setIdCliente(rs.getString("idCliente"));
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
                obj.setJefe(rs.getString("jefe"));
                obj.setLogin(rs.getString("login"));
                obj.setPassword(rs.getString("password"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return obj;
    }

    public Clientes buscarPorNombreContacto(String contacto) {
        Clientes obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from clientes where nombreContacto = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, contacto);
            rs = ps.executeQuery();

            if (rs.next()) {
                obj = new Clientes();
                obj.setIdCliente(rs.getString("idCliente"));
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
                obj.setJefe(rs.getString("jefe"));
                obj.setLogin(rs.getString("login"));
                obj.setPassword(rs.getString("password"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return obj;
    }

    public Clientes buscarPorLogin(String login, String password) {
        Clientes obj = null;
        try {
            con = Conexion.getConnection();
            String sql = "select * from clientes where login = ? and password = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                obj = new Clientes();
                obj.setIdCliente(rs.getString("idCliente"));
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
                obj.setJefe(rs.getString("jefe"));
                obj.setLogin(rs.getString("login"));
                obj.setPassword(rs.getString("password"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) { con.close(); }
                if (ps != null) { ps.close(); }
                if (rs != null) { rs.close(); }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return obj;
    }

    public int eliminar(String id) {
        int result = 0;
        try {
            con = Conexion.getConnection();
            String sql = "delete from clientes where idCliente = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}
