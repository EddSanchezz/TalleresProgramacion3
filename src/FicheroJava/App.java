package FicheroJava;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\metzu\\Documents\\TallerArchivosFicherosJava\\Restaurants.csv";
        Fichero.revisarArchivo(ruta);
        Fichero.escanearArchivo(ruta);
    }
}

