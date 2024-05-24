package Examen2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class EscrituraArchivo {

    public static void EscribirArchivo(String texto, String ruta, int prio) {
        String path = "src\\Examen2\\" + ruta + "_"+ Integer.toString(prio) + "_" + LocalDate.now().toString();
        File miFile = new File(path);


        try {
            PrintWriter writer = new PrintWriter(new FileWriter(miFile, true));

            writer.println(texto);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
