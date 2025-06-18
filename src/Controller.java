
/**
 * Clase Controlador para la calculadora
 * Coordina las interacciones entre Modelo y Vista
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model modelo, View vista) {
        this.model = modelo;
        this.view = vista;
    }

    // Se iguala continuar a true para que corra el programa
    public void iniciar() {
        boolean continuar = true;

        while (continuar) {
            view.menu();
            int opcion = view.leerOpcion();

            //Dependiendo lo que escoja el usuario, se ejecutara una operación o otra
            switch (opcion) {
                case 1 -> ejecutarOperacion("sumar");
                case 2 -> ejecutarOperacion("restar");
                case 3 -> ejecutarOperacion("multiplicar");
                case 4 -> ejecutarOperacion("dividir");
                case 5 -> {
                    view.mostrarMensaje("¡Saliendo!");
                    //Se iguala continuare a false para q se cierre el programa
                    continuar = false;
                }
                default -> view.mostrarError("Opción no válida");
            }
        }
        view.cerrarRecursos();
    }

    //Función en la que recoge el numero introducido por el usuario desde la view y llama al model para saber que operación tiene que hacer, finalmente se muestra el resultado.

    private void ejecutarOperacion(String operacion) {
        try {
            double num1 = view.leerNumero("Introduce el primer número: ");
            double num2 = view.leerNumero("Introduce el segundo número: ");

            model.calcular(num1, num2, operacion);
            view.mostrarResultado(model.getResultado(), operacion);
        } catch (ArithmeticException e) {
            view.mostrarError(e.getMessage());
        } catch (Exception e) {
            view.mostrarError("Error inesperado: " + e.getMessage());
        }
    }
}