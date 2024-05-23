package TallerHilosYSockets.Punto1;

import java.util.Random;

import javax.swing.JOptionPane;

public class Hilo extends Thread {

    private int counter;
    private String name;
    private boolean ganador;

    public Hilo(int counter, String name) {
        this.counter = counter;
        this.name = name;
        this.ganador = false;
    }

    @Override
    public void run() {
        // Hacer que el hilo espere un número aleatorio para iniciar
        Random random = new Random();
        int num = random.nextInt(5000); // Espera hasta 5 segundos
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cuentaRegresiva();
    }

    // Método encargado de hacer esperar para iniciar el hilo en la carrera
    public void cuentaRegresiva() {
        while (this.counter > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.counter--;
            System.out.println(getCounter() + " segundos para que " + name + " termine la carrera.");
        }

        if (this.counter == 0) {
            synchronized (Hilo.class) {
                if (!ganador) {
                    ganador = true;
                    JOptionPane.showMessageDialog(null, "El ganador es el hilo " + getNombre());;
                }
            }
        }
    }

    public int getCounter() {
        return counter;
    }

    public boolean isGanador() {
        return ganador && counter == 0;
    }

    public String getNombre() {
        return name;
    }
}


