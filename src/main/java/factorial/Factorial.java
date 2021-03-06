package factorial;

public class Factorial {
    public long computar(int value) {
        long res;
        if (value < 0) {
            throw new RuntimeException("El factorial de un número negativo no existe");
        } else if (value > 20) {
            throw new RuntimeException("Número introducido demasiado grande");
        } else if ((value == 0) || (value == 1)) {
            res = 1;
        } else if (value == 2) {
            res = 2;
        } else {
            // Computacionalmente es mejor bucle a recursividad
            //res = value * computar(value - 1);
            res = 1;
            for (int i = 1; i <= value; i++) {
                res = i * res;
            }
        }
        return res;
    }
}
