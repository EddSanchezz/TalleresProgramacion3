package LecturaYEscritura;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\metzu\\IdeaProjects\\TalleresProgramacion3\\src\\LecturaYEscritura\\ArchivoCreado.csv";
        LecturaArchivo.leerArchivo(ruta);
        EscrituraArchivo.EscribirArchivo(ruta, "hola mundo");
    }
}
