import java.util.logging.Logger;
//xD
public class Logger1 {

        private static final Logger logger = Logger.getLogger(Logger1.class.getName());

        public static void main(String[] args) {
            int numero1 = 10;
            int numero2 = 20;
            int resultado = sumar(numero1, numero2);

            logger.info("El resultado de sumar " + numero1 + " y " + numero2 + " es: " + resultado);
        }

        public static int sumar(int a, int b) {
            logger.info("Iniciando la operación de suma...");
            int suma = a + b;
            logger.info("Operación de suma completada.");
            return suma;
        }

}