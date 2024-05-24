package Examen2;

import java.io.*;
import java.net.*;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Servidor {
    public static void main(String[] args) {
        
        ServerSocket servidor = null;
        Socket sc = null; //cliente
        final int puerto = 5000;
        DataInputStream in; //informacion que ingresa
        DataOutputStream out; //informacion que sale
            try{
                servidor = new ServerSocket(puerto);
                JOptionPane.showMessageDialog(null,"servidor iniciado, esperando conexion", "cliente", 3);
                while(true){
                    sc = servidor.accept();
                    JOptionPane.showMessageDialog(null , "cliente contectado al servidor","chat", 2);
                    String nombreArchivo = "";
                    int prio=0;
                    String[] texto = null;
                    String[] testiculs;
                    in = new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());
                    while(nombreArchivo != null){
                        nombreArchivo = in.readUTF();
                        JOptionPane.showMessageDialog(null, nombreArchivo);
                        testiculs = nombreArchivo.split(",");

                        texto[1] = LeerArchivo.leerArchivo(testiculs[0]);


                        for(int i=0;i<texto.length;i++){
                            out.writeUTF(LeerArchivo.leerArchivo(texto[i]));
                        }
                        
                    }
                    sc.close(); 
                    JOptionPane.showMessageDialog(null, "cliente desconectado  ^_____^  ");
                }

            }catch(IOException e){
                e.getStackTrace();
            }
    }
}
