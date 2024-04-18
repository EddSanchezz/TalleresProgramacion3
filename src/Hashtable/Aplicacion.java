package Hashtable;


import java.io.IOException;
import java.util.Scanner;

public class Aplicacion
{

    public static void main(String[] args) throws IOException    {
        try (//C:\Users\metzu\Documents\LetraCancion.txt
        Scanner sc = new Scanner(System.in)) {
            System.out.print("ingrese la ruta del archivo: ");
            String archivo = sc.nextLine();
            Archivo.contarPalabrasRepetidas(Archivo.convertirTextoEnLista(archivo));
        }

    }

}
