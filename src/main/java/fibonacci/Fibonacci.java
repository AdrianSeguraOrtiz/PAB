package fibonacci;

public class Fibonacci {
    public long computar(int n, int k) {
        if (n <= 0 || k <= 0) {
            throw new RuntimeException("los parámetros a introducir no pueden ser negativos");
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            // Computacionalmente es mejor bucle a recursividad
            //return computar(n - 1, k) + k * computar(n - 2, k);
            int Fi_2 = 1;
            int Fi_1 = 1;
            int Fi = 1;
            for (int i = 3; i <= n; i++){
                Fi = Fi_1 + k * Fi_2;
                Fi_2 = Fi_1;
                Fi_1 = Fi;
            }
            return Fi;
        }
    }
}
