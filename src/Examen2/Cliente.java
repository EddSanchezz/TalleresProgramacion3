package Examen2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Cliente {
    @SuppressWarnings("unused")
    public static void main(String[] args) {

        final String host = "172.20.10.5";
        final int puerto = 5000;

        DataInputStream in; //informacion que ingresa
        DataOutputStream out; //informacion que sale

        try {
            Socket sc = new Socket(host, puerto);

            String nombreArchivo = "";
            int prio= 0;
            String texto="";

            for(int i= 1; i<=5; i++){
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                nombreArchivo = JOptionPane.showInputDialog("Ingrese el nombre del archivo a copiar y la prioridad separados por coma");
                out.writeUTF(nombreArchivo);


                texto = in.readUTF();
                EscrituraArchivo.EscribirArchivo(texto,nombreArchivo,prio);
            }

            sc.close();


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
