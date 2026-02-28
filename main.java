package main;

import java.util.Scanner;
import java.util.Random;
public class main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: calculadora(); break;
                case 2: validarContrasena(); break;
                case 3: numeroPrimo(); break;
                case 4: sumaPares(); break;
                case 5: conversionTemperatura(); break;
                case 6: contadorVocales(); break;
                case 7: factorial(); break;
                case 8: juegoAdivinanza(); break;
                case 9: pasoPorReferencia(); break;
                case 10: tablaMultiplicar(); break;
                case 0: System.out.println("Saliendo del programa..."); break;
                default: System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Calculadora básica");
        System.out.println("2. Validación de contraseña");
        System.out.println("3. Número primo");
        System.out.println("4. Suma de números pares");
        System.out.println("5. Conversión de temperatura");
        System.out.println("6. Contador de vocales");
        System.out.println("7. Factorial");
        System.out.println("8. Juego de adivinanza");
        System.out.println("9. Paso por referencia");
        System.out.println("10. Tabla de multiplicar");
        System.out.println("0. Salir");
    }

    // ================= VALIDACIONES =================

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número entero.");
            }
        }
    }

    public static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }

    // ================= 1 CALCULADORA =================

    public static void calculadora() {
        double a = leerDouble("Ingrese primer número: ");
        double b = leerDouble("Ingrese segundo número: ");

        System.out.println("1. Suma\n2. Resta\n3. Multiplicación\n4. División");
        int op = leerEntero("Seleccione operación: ");

        switch (op) {
            case 1: System.out.println("Resultado: " + suma(a, b)); break;
            case 2: System.out.println("Resultado: " + resta(a, b)); break;
            case 3: System.out.println("Resultado: " + multiplicacion(a, b)); break;
            case 4:
                if (b != 0)
                    System.out.println("Resultado: " + division(a, b));
                else
                    System.out.println("No se puede dividir entre cero.");
                break;
            default: System.out.println("Operación inválida.");
        }
    }

    public static double suma(double a, double b) { return a + b; }
    public static double resta(double a, double b) { return a - b; }
    public static double multiplicacion(double a, double b) { return a * b; }
    public static double division(double a, double b) { return a / b; }

    // ================= 2 CONTRASEÑA =================

    public static void validarContrasena() {
        String pass;
        do {
            System.out.print("Ingrese contraseña: ");
            pass = sc.nextLine();
        } while (!pass.equals("1234"));

        System.out.println("Acceso concedido.");
    }

    // ================= 3 NÚMERO PRIMO =================

    public static void numeroPrimo() {
        int num = leerEntero("Ingrese un número: ");
        if (esPrimo(num))
            System.out.println("Es primo.");
        else
            System.out.println("No es primo.");
    }

    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    // ================= 4 SUMA PARES =================

    public static void sumaPares() {
        int suma = 0;
        int num = -1;

        while (num != 0) {
            num = leerEntero("Ingrese número (0 para salir): ");
            if (num % 2 == 0)
                suma += num;
        }

        System.out.println("Suma de pares: " + suma);
    }

    // ================= 5 TEMPERATURA =================

    public static void conversionTemperatura() {
        System.out.println("1. Celsius a Fahrenheit");
        System.out.println("2. Fahrenheit a Celsius");

        int op = leerEntero("Seleccione opción: ");
        double temp = leerDouble("Ingrese temperatura: ");

        if (op == 1)
            System.out.println("Resultado: " + celsiusAFahrenheit(temp));
        else if (op == 2)
            System.out.println("Resultado: " + fahrenheitACelsius(temp));
        else
            System.out.println("Opción inválida.");
    }

    public static double celsiusAFahrenheit(double c) {
        return (c * 9/5) + 32;
    }

    public static double fahrenheitACelsius(double f) {
        return (f - 32) * 5/9;
    }

    // ================= 6 VOCALES =================

    public static void contadorVocales() {
        System.out.print("Ingrese texto: ");
        String texto = sc.nextLine();
        System.out.println("Cantidad de vocales: " + contarVocales(texto));
    }

    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (char c : texto.toCharArray())
            if ("aeiou".indexOf(c) != -1)
                contador++;
        return contador;
    }

    // ================= 7 FACTORIAL =================

    public static void factorial() {
        int num = leerEntero("Ingrese número: ");
        if (num < 0) {
            System.out.println("No se permite número negativo.");
            return;
        }

        System.out.println("Factorial: " + calcularFactorial(num));
    }

    public static long calcularFactorial(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++)
            resultado *= i;
        return resultado;
    }

    // ================= 8 ADIVINANZA =================

    public static void juegoAdivinanza() {
        Random rand = new Random();
        int numeroSecreto = rand.nextInt(100) + 1;
        int intento;

        do {
            intento = leerEntero("Adivine el número (1-100): ");

            if (intento < numeroSecreto)
                System.out.println("Es mayor.");
            else if (intento > numeroSecreto)
                System.out.println("Es menor.");

        } while (intento != numeroSecreto);

        System.out.println("¡Correcto!");
    }

    // ================= 9 PASO POR REFERENCIA =================

    static class Numero {
        int valor;
        Numero(int valor) { this.valor = valor; }
    }

    public static void pasoPorReferencia() {
        Numero a = new Numero(5);
        Numero b = new Numero(10);

        System.out.println("Antes: a=" + a.valor + " b=" + b.valor);
        intercambiar(a, b);
        System.out.println("Después: a=" + a.valor + " b=" + b.valor);
    }

    public static void intercambiar(Numero x, Numero y) {
        int temp = x.valor;
        x.valor = y.valor;
        y.valor = temp;
    }

    // ================= 10 TABLA =================

    public static void tablaMultiplicar() {
        int num = leerEntero("Ingrese número: ");

        for (int i = 1; i <= 10; i++)
            System.out.println(num + " x " + i + " = " + (num * i));
    }
}