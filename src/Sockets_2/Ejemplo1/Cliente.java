package Sockets_2.Ejemplo1;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345); // Conexión al servidor en localhost, puerto 12345
            System.out.println("Conectado al servidor.");

            // Flujo de salida para enviar datos al servidor
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            // Envía un mensaje al servidor
            String mensaje = "";
            while(mensaje != "salir"){
                mensaje = JOptionPane.showInputDialog("ingrese un mensaje para el servidor (: ");
                dataOutputStream.writeUTF(mensaje);
            }
            

            // Cierre de flujos y socket
            dataOutputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
