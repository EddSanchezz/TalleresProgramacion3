package FicheroJava;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Fichero {

    public static void verificarArchivo (String ruta){
        File fichero = new File(ruta);
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

    public static ArrayList<Restaurante> organizarRestaurantes(String ruta) throws IOException {
        File archivo = new File(ruta);
        FileReader miFiledReader = new FileReader(archivo);
        ArrayList <Restaurante> ListaRest = new ArrayList<>();
        try (BufferedReader miBufferReader = new BufferedReader(miFiledReader)) {
            
            String linea;
            while((linea = miBufferReader.readLine()) != null){
                String resultado = "";
                boolean dentroComillas = false;
                for (int i = 0; i < linea.length(); i++){
                    char caracter = linea.charAt(i);
                    if (caracter == '\"'){
                        dentroComillas = !dentroComillas;
                    }else if (caracter == ',' && dentroComillas) {
                        resultado += ' ';
                    }else{
                        resultado += caracter;
                    }
                }
                linea = resultado;
                String[] restaurante = linea.split(",");
                ListaRest.add( new Restaurante(restaurante[0],restaurante[1],restaurante[2], restaurante[3],restaurante[4]));

            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return ListaRest;

    }

    public static ArrayList<Integer> showDataZipCode(ArrayList<Restaurante> ListaRest){
        ArrayList<Integer> posiciones = new ArrayList<>();
        int codigo;
        for(int i=1; i<ListaRest.size(); i++){
            try {
                codigo = Integer.parseInt(ListaRest.get(i).getCodigo());
                if(codigo >= 60000 && codigo < 70000 ){
                    posiciones.add(codigo); 
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: la cadena '" + ListaRest.get(i).getCodigo() + "' no es un número válido.");
            }
        }
        return posiciones;
    }
}
