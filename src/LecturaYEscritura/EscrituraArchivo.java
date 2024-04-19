package LecturaYEscritura;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class EscrituraArchivo{
    private static Logger log = new Loggeri
    
    public static void EscribirArchivo(String ruta, ArrayList<String> texto) throws IOException{
        FileWriter escribir;
        escribir = new FileWriter(ruta);
        escribir.write("hola mundo");
        escribir.close();
        
        }
}