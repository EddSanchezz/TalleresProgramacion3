package Loggers;

import java.util.Arrays;
import java.util.logging.Logger;

public class Logger3 {

    private static final Logger logger = Logger.getLogger(Logger3.class.getName());

    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}};
        int[][] matriz2 = {{7, 8}, {9, 10}, {11, 12}};
        int[][] resultado = multiplicarMatrices(matriz1, matriz2);

        logger.info("Matriz 1:");
        mostrarMatriz(matriz1);
        logger.info("Matriz 2:");
        mostrarMatriz(matriz2);
        logger.info("Resultado de la multiplicación:");
        mostrarMatriz(resultado);
    }

    public static int[][] multiplicarMatrices(int[][] matriz1, int[][] matriz2) {
        int filas1 = matriz1.length;
        int columnas1 = matriz1[0].length;
        int columnas2 = matriz2[0].length;
        int[][] resultado = new int[filas1][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas2; j++) {
                for (int k = 0; k < columnas1; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        return resultado;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            logger.info(Arrays.toString(fila));
        }
    }
}
