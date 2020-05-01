package factorial;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class FactorialTest {

    private Factorial f;

    private void el_Factorial_De_X_Da_Y(int x, long y){
        assertEquals(y,f.computar(x));
    }
    private void el_Factorial_De_X_Da_Error(int x){
        assertThrows(RuntimeException.class, () -> f.computar(x));
    }

    @BeforeEach
    public void setUp(){
        f = new Factorial();
    }

    @Test
    public void elFactorialDe0Da1(){
        el_Factorial_De_X_Da_Y(0, 1);
    }

    @Test
    public void elFactorialDe1Da1(){
        el_Factorial_De_X_Da_Y(1, 1);
    }

    @Test
    public void elFactorialDe2Da2(){
        el_Factorial_De_X_Da_Y(2, 2);
    }
    @Test
    public void elFactorialDe4Da24(){
        el_Factorial_De_X_Da_Y(4, 24);
    }

    @Test
    public void elFactorialDeNumNegDaError(){
        el_Factorial_De_X_Da_Error(-1);
    }
    @Test
    public void elFactorialDeNumGrandeDaError(){
        el_Factorial_De_X_Da_Error(21);
    }
}

