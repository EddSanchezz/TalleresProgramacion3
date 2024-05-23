package Sockets_2.ClienteServidor;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) throws IOException {
        
            ServerSocket servidor = null;
            Socket sc = null;
            final int puerto = 5000;
            DataInputStream in; //informacion que ingresa
            DataOutputStream out; //informacion que sale
            try{
                servidor = new ServerSocket(puerto);
                System.out. println("servidor iniciado, esperando conexion");


                while(true){
                    sc = servidor.accept();
                    System.out.println("cliente contectado al servidor");

                    String mensaje = "";
                    in = new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());

                    
                    while(mensaje != null){
                        mensaje = in.readUTF();
                        System.out.println(mensaje);
                    }
                    

                    out.writeUTF("hola mundo desde el servidor");

                    sc.close(); 
                    System.out.println("cliente desconectado");

                    
                }
            }catch(IOException e){
                e.getStackTrace();
            }
    }
}
