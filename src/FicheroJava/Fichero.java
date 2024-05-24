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

    public static ArrayList<Restaurante> organizarRestaurantesEnTexto(String ruta) throws IOException {
        File archivo = new File(ruta);
        FileReader miFiledReader = new FileReader(archivo);
        ArrayList <Restaurante> ListaRest = new ArrayList<>();
        try (BufferedReader miBufferReader = new BufferedReader(miFiledReader)) {
            
            String linea;
            while((linea = miBufferReader.readLine()) != null){
                StringBuilder resultado = getStringBuilder(linea);
                linea = resultado.toString();
                String[] restaurante = linea.split(",");
                ListaRest.add( new Restaurante(restaurante[0],restaurante[1],restaurante[2], restaurante[3],restaurante[4]));

            }
        }

        return ListaRest;

    }

    private static StringBuilder getStringBuilder(String linea) {
        StringBuilder resultado = new StringBuilder();
        boolean dentroComillas = false;
        for (int i = 0; i < linea.length(); i++){
            char caracter = linea.charAt(i);
            if (caracter == '\"'){
                dentroComillas = !dentroComillas;
            }else if (caracter == ',' && dentroComillas) {
                resultado.append(' ');
            }else{
                resultado.append(caracter);
            }
        }
        return resultado;
    }

    public static void showDataZipCode(ArrayList<Restaurante> ListaRest){
        ArrayList<Restaurante> restaurantesCon6 = new ArrayList<>();
        int codigo;
        for(int i=1; i<ListaRest.size(); i++){
            try {
                codigo = Integer.parseInt(ListaRest.get(i).getCodigo());
                if(codigo >= 60000 && codigo < 70000 ){
                    restaurantesCon6.add(ListaRest.get(i));
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: la cadena '" + ListaRest.get(i).getCodigo() + "' no es un número válido.");
            }
        }
        for(Restaurante rest : restaurantesCon6){
            JOptionPane.showMessageDialog(null, "restaurantes con el numero inicial del codigo postal: " + rest.getNombre() + ", " + rest.getDireccion() + ", " + rest.getCiudad() + ", " + rest.getEstado() + ", " + rest.getCodigo());
        }
    }

    public static void EscribirArchivo(String ruta, Restaurante Restaurante) {
        File miFile = new File(ruta);

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(miFile, true));

            writer.println(Restaurante.getNombre() + ", "+ Restaurante.getDireccion()+ ", " + Restaurante.getCiudad()+ ", " + Restaurante.getEstado() + ", " + Restaurante.getCodigo());

            writer.close();

        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    public  static void AgregarRestaurante(String ruta) {

        String num = JOptionPane.showInputDialog(null, "ingrese el numero de restaurantes que desea ingresar:");
        int cantidad = Integer.parseInt(num);
        while (cantidad > 0) {
            
            
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre:  ");
            String direccion = JOptionPane.showInputDialog(null, "Ingrese la direccion:  ");
            String ciudad = JOptionPane.showInputDialog(null, "Ingrese la ciudad:  ");
            String estado = JOptionPane.showInputDialog(null, "Ingrese el estado:  ");
            String codigo = JOptionPane.showInputDialog(null, "Ingrese el codigo postal:  ");

            Fichero.EscribirArchivo(ruta, new Restaurante(nombre, direccion, ciudad, estado, codigo));


            cantidad --;

        }
        

    }
    public static void copiarArchivoExcluyendo6(String ruta, String ruta2) throws IOException {
        ArrayList<Restaurante> restaurantes = organizarRestaurantesEnTexto(ruta);
        File archivoDestino = new File(ruta2);

        if (!archivoDestino.exists()) {
            archivoDestino.createNewFile();
        }

        PrintWriter writer = new PrintWriter(new FileWriter(archivoDestino));

        for (Restaurante restaurante : restaurantes) {
            if (!restaurante.getCodigo().startsWith("6")) {
                writer.println(restaurante.getNombre() + ", " + restaurante.getDireccion() + ", " + restaurante.getCiudad() + ", " + restaurante.getEstado() + ", " + restaurante.getCodigo());
            }
        }

        writer.close();
    }

    public static void borrarArchivo(String ruta) {
        File archivo = new File(ruta);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("El archivo ha sido eliminado correctamente.");
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
