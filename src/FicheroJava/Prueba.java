package FicheroJava;

import java.io.IOException;
import java.util.ArrayList;

public class Prueba {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\metzu\\Documents\\TallerArchivosFicherosJava\\Restaurants.csv";
        try {
            ArrayList<Restaurante> ListaRest = Fichero.organizarRestaurantes(ruta);
            //ArrayList<Integer> ListaPos = Fichero.showDataZipCode(ListaRest);
            System.out.println(ListaRest.get(1).getCodigo()); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
