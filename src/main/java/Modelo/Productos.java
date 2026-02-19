package Modelo;

public class Productos {

    private int idProducto;
    private String nombreProducto;
    private int idProveedor;
    private int idCategoria;
    private String cantidadPorUnidad;
    private double precioUnidad;
    private int unidadesEnExistencia;
    private int unidadesEnPedido;
    private int nivelNuevoPedido;
    private boolean suspendido;

    public Productos() {
    }

    public Productos(int idProducto, String nombreProducto, int idProveedor, int idCategoria, String cantidadPorUnidad, double precioUnidad, int unidadesEnExistencia, int unidadesEnPedido, int nivelNuevoPedido, boolean suspendido) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idProveedor = idProveedor;
        this.idCategoria = idCategoria;
        this.cantidadPorUnidad = cantidadPorUnidad;
        this.precioUnidad = precioUnidad;
        this.unidadesEnExistencia = unidadesEnExistencia;
        this.unidadesEnPedido = unidadesEnPedido;
        this.nivelNuevoPedido = nivelNuevoPedido;
        this.suspendido = suspendido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    public void setCantidadPorUnidad(String cantidadPorUnidad) {
        this.cantidadPorUnidad = cantidadPorUnidad;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getUnidadesEnExistencia() {
        return unidadesEnExistencia;
    }

    public void setUnidadesEnExistencia(int unidadesEnExistencia) {
        this.unidadesEnExistencia = unidadesEnExistencia;
    }

    public int getUnidadesEnPedido() {
        return unidadesEnPedido;
    }

    public void setUnidadesEnPedido(int unidadesEnPedido) {
        this.unidadesEnPedido = unidadesEnPedido;
    }

    public int getNivelNuevoPedido() {
        return nivelNuevoPedido;
    }

    public void setNivelNuevoPedido(int nivelNuevoPedido) {
        this.nivelNuevoPedido = nivelNuevoPedido;
    }

    public boolean isSuspendido() {
        return suspendido;
    }

    public void setSuspendido(boolean suspendido) {
        this.suspendido = suspendido;
    }
}
