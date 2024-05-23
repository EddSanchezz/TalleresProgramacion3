package Sockets_2.Ejemplo1;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Puerto del servidor
            System.out.println("Servidor esperando conexiones...");

            Socket clienteSocket = serverSocket.accept(); // Espera a que un cliente se conecte
            System.out.println("Cliente conectado.");

            // Flujo de entrada del cliente
            InputStream inputStream = clienteSocket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            // Lee el mensaje enviado por el cliente

            String mensajeCliente = "";
            while(mensajeCliente != "salir"){
                mensajeCliente = dataInputStream.readUTF();
                System.out.println("Mensaje recibido del cliente: " + mensajeCliente);
            }

            // Cierre de flujos y sockets
            dataInputStream.close();
            inputStream.close();
            clienteSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

