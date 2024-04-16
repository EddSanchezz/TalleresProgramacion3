package FicheroJava;

public class Restaurante {
    private String nombre;
    private String estado;
    private String direccion;
    private int codigo;

    public Restaurante(String nombre, String estado, String direccion, int codigo) {
        this.nombre = nombre;
        this.estado = estado;
        this.direccion = direccion;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
