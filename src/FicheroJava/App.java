package FicheroJava;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) throws IOException {
        String ruta = "C:\\Users\\metzu\\Documents\\Repositorios\\TalleresProgramacion3\\src\\FicheroJava\\Restaurants.csv";
        String ruta2 = "C:\\Users\\metzu\\Documents\\Repositorios\\TalleresProgramacion3\\src\\FicheroJava\\Restaurants2.csv";
        ArrayList<Restaurante> ListaRest = Fichero.organizarRestaurantesEnTexto(ruta);

        //ejercicio1: verificar si el archivo existe, y dar informacion de este
        Fichero.verificarArchivo(ruta);

        //ejercicio2: mostrar los restaurantes con el codigo postal que comience en 6
        Fichero.showDataZipCode(ListaRest);
            
        //ejercicio3: metodo para que el usuario ingrese mas restaurantes
        Fichero.AgregarRestaurante(ruta);

        //ejercicio4: crear otro archivo que contenga la informacion excepto la informacion dada en el punto 2
        Fichero.copiarArchivoExcluyendo6(ruta, ruta2);

        //ejercicio5: crar un metodo que que borre el fichero cuya ruta ha sido introducida por el usuario
        String rutaEliminar = JOptionPane.showInputDialog(null, "ingrese la ruta del archivo que desea eliminar: ");
        Fichero.borrarArchivo(rutaEliminar);
    }
    
}

