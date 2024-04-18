package FicheroJava;

public class Restaurante {
    private String nombre;
    private String estado;
    private String direccion;
    private String codigo;
    private String ciudad;

    


    public Restaurante(String nombre, String direccion, String ciudad, String estado, String codigo) {
        this.nombre = nombre;
        this.estado = estado;
        this.direccion = direccion;
        this.codigo = codigo;
        this.ciudad = ciudad;
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }



    public String getCiudad() {
        return ciudad;
    }



    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
}
