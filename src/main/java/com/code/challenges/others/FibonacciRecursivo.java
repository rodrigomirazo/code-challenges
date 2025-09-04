package com.code.challenges.others;

public class FibonacciRecursivo {

    public static void main(String[] args) {
        int n = 10; // Número de elementos que se quieren mostrar

        System.out.println("La serie Fibonacci es:");
        System.out.print(fibonacci(10) + " ");
        /*
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        */
    }

    // Método para calcular el n-ésimo número de Fibonacci recursivamente
    public static int fibonacci(int n) {
        System.out.println(" " + n);
        if (n <= 1) {
            return n; // Casos base: F(0)=0, F(1)=1
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Llamada recursiva
        }
    }
}