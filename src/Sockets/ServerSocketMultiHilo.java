package Sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class ServerSocketMultiHilo extends Thread{

    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8090)){
            System.out.println("esperando conexiones ....");
            while(true){
                Socket client = server.accept();
                String name = client.getInetAddress().getHostAddress();
                System.out.printf("usuario %s conectado", name);
                new WorkerSocket(client,name).start();
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
