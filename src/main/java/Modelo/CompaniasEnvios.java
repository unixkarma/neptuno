package Modelo;

public class CompaniasEnvios {

    private int idCompania;
    private String nombreCompania;
    private String telefono;

    public CompaniasEnvios() {
    }

    public CompaniasEnvios(int idCompania, String nombreCompania, String telefono) {
        this.idCompania = idCompania;
        this.nombreCompania = nombreCompania;
        this.telefono = telefono;
    }

    public int getIdCompania() {
        return idCompania;
    }

    public void setIdCompania(int idCompania) {
        this.idCompania = idCompania;
    }

    public String getNombreCompania() {
        return nombreCompania;
    }

    public void setNombreCompania(String nombreCompania) {
        this.nombreCompania = nombreCompania;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
