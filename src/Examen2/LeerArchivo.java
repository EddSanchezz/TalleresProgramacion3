package Examen2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Logger;

public class LeerArchivo {
    public static String leerArchivo(String textito) {
        String texto = null;
        String ruta = "src\\Examen2\\" + textito;
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea;
                texto += "\n";
            }
            JOptionPane.showMessageDialog(null, "Archivo leido");
        } catch (IOException e) {
        }


        return texto;
    }
    public static void prioridad(int prioridad, String texto){
        ArrayList<String> textos = new ArrayList<>();

    }

    public static void verificarArchivo(String ruta) {
        File fichero = new File(ruta);
        String lectura;
        String escritura;

        if (fichero.exists()) {
            lectura = "existe \\(￣︶￣*\\))";
        } else {
            lectura = "no existe （；´д｀）ゞ";
        }
    }

}





