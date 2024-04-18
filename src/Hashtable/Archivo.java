package Hashtable;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class Archivo {

    public static ArrayList<String> convertirTextoEnLista(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String[] palabrasDivididas = linea.split(" ");
                lineas.addAll(Arrays.asList(palabrasDivididas));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineas;
    }

    public static void contarPalabrasRepetidas(ArrayList<String> palabras) throws IOException {
        Map<String, Integer> contadorPalabras = new HashMap<>();

        for (String palabra : palabras) {
            contadorPalabras.put(palabra, contadorPalabras.getOrDefault(palabra, 0) + 1);
        }

        String palabraMasRepetida = "";
        int maxRepetida = 0;

        for (Map.Entry<String, Integer> entry : contadorPalabras.entrySet()) {
            if (entry.getValue() > maxRepetida) {
                palabraMasRepetida = entry.getKey();
                maxRepetida = entry.getValue();
            }
        }

        String mensaje = "La palabra más repetida es: " + palabraMasRepetida + "Se repite " + maxRepetida + " veces.";

         String ruta2 = "C:\\Users\\metzu\\Documents\\palabraRepetida.txt";
         File archivo = new File(ruta2);
         try{
             PrintWriter salida = new PrintWriter(archivo);
             salida.close();
             JOptionPane.showMessageDialog(null, "archivo mensaje de palabras repetidas guardados con exito");
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         }

         FileWriter escribir = new FileWriter(archivo);
         escribir.write(mensaje);
         escribir.flush();
         escribir.close();
    }
}
