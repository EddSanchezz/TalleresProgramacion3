package FicheroJava;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Fichero {

    public static void revisarArchivo (String ruta){
        File fichero = new File(ruta);
        String linea;
        String lectura;
        String escritura;

        if(fichero.canRead()){
            lectura = "se puede leer";
        }else{
            lectura = "no se puede leer";
        }
        if(fichero.canWrite()){
            escritura = "se puede escribir";
        }else{
            escritura = "no se puede escribir";
        }

        if(fichero.exists()){
            if(fichero.isDirectory()){
                JOptionPane.showMessageDialog(null, "el directorio existe, y se llama: " + fichero.getName());
            } else if (fichero.isFile()) {
                JOptionPane.showMessageDialog(null, "el archivo existe, y se llama: " + fichero.getName() + " , "+ lectura + " y " + escritura + ", tambien tiene un tamaño de: " + fichero.length() + " bytes");
            }

        }else{
            JOptionPane.showMessageDialog(null, "el archivo no existe");
        }

    }

    public static void escanearArchivo(String ruta) throws IOException {
        File archivo = new File(ruta);
        FileReader miFiledReader = new FileReader(archivo);
        BufferedReader miBufferReader = new BufferedReader(miFiledReader);

        ArrayList <Restaurante> ListaRest = new ArrayList<>();
        String linea;
        while((linea = miBufferReader.readLine()) != null){
            String[] restaurante = linea.split(",");
            int codigo = Integer.parseInt(restaurante[3]);
            ListaRest.add( new Restaurante(restaurante[0],restaurante[1],restaurante[2], codigo));

        }
    }
}
