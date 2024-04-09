package Hashtable;

public class Propietario {
    private String codigo;
    private String nombre;
    private String telefonoP;

    public Propietario(String codigo, String nombre, String telefonoP) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.telefonoP = telefonoP;
    }

    public Propietario(){}

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoP() {
        return telefonoP;
    }

    public void setTelefonoP(String telefonoP) {
        this.telefonoP = telefonoP;
    }
}
