package Sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class WorkerSocket extends Thread{
    private Socket client;
    private String name;

    

    public WorkerSocket (Socket client, String name) {
        this.client = client;
        this.name = name;
    }

    @Override
    public void run(){
        try(DataInputStream data = new DataInputStream(this.client.getInputStream())){
            String message;
            do{
                message = data.readUTF();
                System.out.printf("%s dice: %s \n", this.name, message);
                this.client.close();
            }while(!message.equalsIgnoreCase("salir"));
            System.out.println("desconectado " + this.name);
            this.client.close();

        }catch(IOException e){
            System.out.println();
        }
    }
}
