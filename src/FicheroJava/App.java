package FicheroJava;

import java.io.IOException;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\metzu\\Documents\\Repositorios\\TalleresProgramacion3\\src\\FicheroJava\\Restaurants.csv";
        try {
            Fichero.verificarArchivo(ruta);
            ArrayList<Restaurante> ListaRest = Fichero.organizarRestaurantes(ruta);
            ArrayList<Integer> ListaPos = Fichero.showDataZipCode(ListaRest);
            for(int i=0; i<ListaPos.size(); i++){
                System.out.println(ListaPos.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

