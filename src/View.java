import java.util.Scanner;

/**
 * Clase Vista para la calculadora
 * Maneja toda la interacción con el usuario
 */
public class View {
    private static Scanner sc = new Scanner(System.in);

    // Menu con todas las opciones de iteración del usuario
    public static void menu() {
        System.out.println("\n---- Calculadora Simple ----");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    // Funcion que sirve para recoger la opicón del usuario y limpiar el buffer
    public int leerOpcion() {
        try {
            return sc.nextInt();
        } catch (Exception e) {
            sc.nextLine(); // Limpiar buffer
            return -1; // Opción inválida
        }
    }

    // Funcion que sirve para recoger el número del usuario y limpiar el buffer
    public double leerNumero(String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextDouble()) {
            sc.next(); // Limpiar buffer
            System.out.print("Entrada inválida. " + mensaje);
        }
        return sc.nextDouble();
    }

    //Función que sirve para mostrar el resultado de la operación
    public void mostrarResultado(double resultado, String operacion) {
        System.out.println("El resultado de " + operacion + " es: " + resultado);
    }

    // Función que muestra errores
    public void mostrarError(String mensaje) {
        System.err.println("Error: " + mensaje);
    }
    // Función para mostrar mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    // Función para cerrar el sc
    public void cerrarRecursos() {
        sc.close();
    }
}

