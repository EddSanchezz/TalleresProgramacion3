package Hashtable;


import java.util.Scanner;

public class Aplicacion
{

    public static void main(String[] args)    {
        //C:\Users\metzu\Documents\LetraCancion.txt
        Scanner sc = new Scanner(System.in);
        System.out.print("ingrese la ruta del archivo: ");
        String archivo = sc.nextLine();
        Archivo.contarPalabrasRepetidas(Archivo.convertirTextoEnLista(archivo));

    }

}
