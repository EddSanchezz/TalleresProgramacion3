package co.edu.uniquindio.poo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ClientSocket {
    
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 8090)){
            DataOutputStream data = new DataOutputStream(socket.getOutputStream());
            String message;
            do{
                message = JOptionPane.showInputDialog("ingrese su mensaje");
                System.out.println(message);
                data.writeUTF(message);
            }while(true);
        }catch(UnknownHostException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
