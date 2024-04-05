import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class Logger2 {

    private static final Logger logger = Logger.getLogger(Logger2.class.getName());

    public static void main(String[] args) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1; // Número aleatorio entre 1 y 100
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        boolean haAdivinado = false;

        logger.info("¡Bienvenido al juego de adivinar el número!");

        while (!haAdivinado) {
            logger.info("Introduce tu intento:");
            int intento = scanner.nextInt();
            intentos++;

            if (intento == numeroAleatorio) {
                haAdivinado = true;
                logger.info("¡Felicidades! Has adivinado el número en " + intentos + " intentos.");
            } else if (intento < numeroAleatorio) {
                logger.info("El número es mayor. Sigue intentando.");
            } else {
                logger.info("El número es menor. Sigue intentando.");
            }
        }

        scanner.close();
    }
}
