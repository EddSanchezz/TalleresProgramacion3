package Sockets_2.ClienteServidor;

import java.io.*;
import java.net.*;

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

                    String mensaje = "";
                    in = new DataInputStream(sc.getInputStream());
                    out = new DataOutputStream(sc.getOutputStream());

                    
                    
                    while(mensaje != null){
                        mensaje = in.readUTF();
                        JOptionPane.showMessageDialog(null, mensaje);
                        //envia el mensaje al cliente
                        //out.writeUTF("hola desde servidor");
                    }
                    

                    sc.close(); 
                    JOptionPane.showMessageDialog(null, "cliente desconectado");

                    
                }
            }catch(IOException e){
                e.getStackTrace();
            }
    }
}
