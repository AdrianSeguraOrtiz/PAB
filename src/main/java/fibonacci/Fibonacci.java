package fibonacci;

public class Fibonacci {
    public long computar(int n, int k) {
        if (n <= 0 || k <= 0) {
            throw new RuntimeException("los parámetros a introducir no pueden ser negativos");
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            return k * computar(n - 2, k) + computar(n - 1, k);
        }
    }
}
