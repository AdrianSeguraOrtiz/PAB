package fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciTest {

    private Fibonacci f;

    private void el_Fibonacci_N_Con_K_Da_X(int n, int k, long x) {
        assertEquals(x, f.computar(n, k));
    }

    private void el_Fibonacci_N_Con_K_Da_Error(int n, int k) {
        assertThrows(RuntimeException.class, () -> f.computar(n, k));
    }

    @BeforeEach
    public void setUp() {
        f = new Fibonacci();
    }

    @Test
    public void elFibonacciN5ConK3Da19() {
        el_Fibonacci_N_Con_K_Da_X(5, 3, 19);
    }

    @Test
    public void elFibonacciN6ConK3Da40() {
        el_Fibonacci_N_Con_K_Da_X(6, 3, 40);
    }

    @Test
    public void elFibonacciN5ConK5Da41() {
        el_Fibonacci_N_Con_K_Da_X(5, 5, 41);
    }

    @Test
    public void elFibonacciNNegDaError() {
        el_Fibonacci_N_Con_K_Da_Error(-1, 1);
    }

    @Test
    public void elFibonacciKNegDaError() {
        el_Fibonacci_N_Con_K_Da_Error(1, -1);
    }

    @Test
    public void elFibonacciNNegYKNegDaError() {
        el_Fibonacci_N_Con_K_Da_Error(-1, -1);
    }
}
