package Hashtable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public static void contarPalabrasRepetidas(ArrayList<String> palabras) {
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

        System.out.println("La palabra más repetida es: " + palabraMasRepetida);
        System.out.println("Se repite " + maxRepetida + " veces.");
    }
}
