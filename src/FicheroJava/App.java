package FicheroJava;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        String ruta = "C:\\Users\\metzu\\IdeaProjects\\TalleresProgramacion3\\src\\FicheroJava\\Restaurants.csv";
        try {
            Fichero.verificarArchivo(ruta);
            ArrayList<Restaurante> ListaRest = Fichero.organizarRestaurantes(ruta);
            ArrayList<Integer> ListaPos = Fichero.showDataZipCode(ListaRest);
            String codigos = "";
            for(int i=0; i<ListaPos.size(); i++){
                codigos += ListaPos.get(i);
                if(i< ListaPos.size()-1){
                    codigos += ", ";
                }
                
            }
            JOptionPane.showMessageDialog(null, "los codigos que inician con 6 son: " + codigos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

