package Sockets_2.ClienteServidor;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        
            ServerSocket servidor = null;
            Socket sc = null; //cliente 
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
                        //envia el mensaje al cliente
                        out.writeUTF("hola desde servidor");
                    }
                    

                    sc.close(); 
                    System.out.println("cliente desconectado");

                    
                }
            }catch(IOException e){
                e.getStackTrace();
            }
    }
}
