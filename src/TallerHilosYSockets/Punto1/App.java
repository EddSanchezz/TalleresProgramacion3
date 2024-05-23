package TallerHilosYSockets.Punto1;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {
        int tiempo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tiempo en segundos para la carrera: "));
        ArrayList<Hilo> hilos = crearDiezHilos(tiempo);
        for (int i = 0; i < 10; i++) {
            hilos.get(i).start();
        }
    }

    public static ArrayList<Hilo> crearDiezHilos(int counter) {
        ArrayList<Hilo> hilos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String name = JOptionPane.showInputDialog("Ingrese el nombre del hilo: ");
            hilos.add(new Hilo(counter, name));
        }
        return hilos;
    }

}
