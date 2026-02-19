package Modelo;

public class Empleados {

    private int idEmpleado;
    private String apellidos;
    private String nombre;
    private String cargo;
    private String tratamiento;
    private String fechaNacimiento;
    private String fechaContratacion;
    private String direccion;
    private String ciudad;
    private String region;
    private String codPostal;
    private String pais;
    private String telDomicilio;
    private String extension;

    public Empleados() {
    }

    public Empleados(int idEmpleado, String apellidos, String nombre, String cargo, String tratamiento, String fechaNacimiento, String fechaContratacion, String direccion, String ciudad, String region, String codPostal, String pais, String telDomicilio, String extension) {
        this.idEmpleado = idEmpleado;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.cargo = cargo;
        this.tratamiento = tratamiento;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.codPostal = codPostal;
        this.pais = pais;
        this.telDomicilio = telDomicilio;
        this.extension = extension;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelDomicilio() {
        return telDomicilio;
    }

    public void setTelDomicilio(String telDomicilio) {
        this.telDomicilio = telDomicilio;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
