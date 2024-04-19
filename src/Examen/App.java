package Examen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static void main(String[] args) {
        String ruta1 = "C:\\Users\\metzu\\IdeaProjects\\TalleresProgramacion3\\src\\Examen\\amazon_cells_labelled.txt";
        String ruta2 = "C:\\Users\\metzu\\IdeaProjects\\TalleresProgramacion3\\src\\Examen\\imdb_labelled.txt";
        String ruta3 = "C:\\Users\\metzu\\IdeaProjects\\TalleresProgramacion3\\src\\Examen\\yelp_labelled.txt";
        ArrayList<String> texto1 = convertirTextoEnLista(ruta1);
        ArrayList<String> texto2 = convertirTextoEnLista(ruta2);
        ArrayList<String> texto3 = convertirTextoEnLista(ruta3);
        ArrayList<String> textos = new ArrayList<>();
        textos.addAll(texto1);
        textos.addAll(texto2);
        textos.addAll(texto3);
        String rutaN = "C:\\Users\\metzu\\IdeaProjects\\TalleresProgramacion3\\src\\Examen\\UNO\\amazon_cells_labelled\\negativo\\sentiments_negativo.txt";
        String rutaP = "C:\\Users\\metzu\\IdeaProjects\\TalleresProgramacion3\\src\\Examen\\UNO\\amazon_cells_labelled\\positivo\\sentiments_positivo.txt";
        ArrayList<String> textosConDip = cambiarDiptongos(textos);
        seleccionarArchivos(textosConDip, rutaP, rutaN);
    }

    public static ArrayList<String> convertirTextoEnLista(String archivo) {
        ArrayList<String> lineas = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                lineas.add(linea);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return lineas;
    }

    public static void seleccionarArchivos(ArrayList<String> listaStrings, String rutaP, String rutaN) {
        for (String str : listaStrings) {
            char ultimoCaracter = str.charAt(str.length() - 1);
            if (ultimoCaracter == '0') {
                escribirArchivo(rutaN, str); 
            } else if (ultimoCaracter == '1') {
                escribirArchivo(rutaP, str); 
            }
        }
    }

    public static void escribirArchivo(String nombreArchivo, String contenido) {
        File archivo = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
            salida.println(contenido);
            salida.close();
            System.out.println("escribiendo...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> cambiarDiptongos(ArrayList<String> textos) {
        ArrayList<String> textoDiptongo = new ArrayList<>();

        Pattern patronDiptongo = Pattern.compile("(?i)\\b\\w*[aeiou]+[aeiou]+\\w*\\b");

        
        for (String parrafo : textos) {
           
            Matcher matcher = patronDiptongo.matcher(parrafo);

            
            StringBuffer textoModificado = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(textoModificado, "DIPTONGO");
            }
            matcher.appendTail(textoModificado);

            
            textoDiptongo.add(textoModificado.toString());
        }

        return textoDiptongo;
    }
}
