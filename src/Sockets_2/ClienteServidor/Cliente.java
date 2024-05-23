package Sockets_2.ClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {

        final String host = "192.168.1.24";
        final int puerto = 5000;

        DataInputStream in; //informacion que ingresa
        DataOutputStream out; //informacion que sale

        try {
            Socket sc = new Socket(host, puerto);

            String mensaje = "";

            while(mensaje!= null){
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                mensaje = JOptionPane.showInputDialog("Ingrese un mensaje para el servidor");
                out.writeUTF(mensaje);
            }

            sc.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
