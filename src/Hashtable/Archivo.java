package Hashtable;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;

public class Archivo
{
    public static void crearArchivo(){
        Formatter archivo;

        try{
            archivo = new Formatter("C:\\Users\\metzu\\Documents\\TallerArchivosFicherosJava\\Restaurants2.txt");
            archivo.flush();
            archivo.close();

            JOptionPane.showMessageDialog(null, "el archivo se creo correctamente");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String contarPalabraMasRepetida()
    {
        String archivo = "C:\\Users\\metzu\\Documents\\TallerArchivosFicherosJava\\LetraCancion.txt";
        String answer;
        String palabraMayor = " ";
        int counter = 0;
        ArrayList<String> lineas = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(archivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

           String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] palabrasDividas = listaDeTexto(linea);
                lineas.addAll(Arrays.asList(palabrasDividas));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        answer = "la palabra mas repetida fue " + palabraMayor + " que se repitió " + counter;
        return answer;
    }

    public static String[] listaDeTexto(String parrafo)
    {
        return parrafo.split(" ");

    }
}
