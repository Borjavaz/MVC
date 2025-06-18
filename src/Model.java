public class Model {
    private double resultado;
    private String operacion;

    public Model() {
        this.resultado = 0;
        this.operacion = "";
    }

    public void calcular(double num1, double num2, String operacion) throws ArithmeticException {
        this.operacion = operacion;
        // Switch con las respectivas operaciones segun la opción y excepción al dividir entre 0
        switch (operacion) {
            case "sumar":
                this.resultado = num1 + num2;
                break;
            case "restar":
                this.resultado = num1 - num2;
                break;
            case "multiplicar":
                this.resultado = num1 * num2;
                break;
            case "dividir":
                if (num2 == 0) {
                    throw new ArithmeticException("No se puede dividir entre cero");
                }
                this.resultado = num1 / num2;
                break;
            default:
                throw new IllegalArgumentException("Operación no válida");
        }
    }

    public double getResultado() {
        return resultado;
    }
}



