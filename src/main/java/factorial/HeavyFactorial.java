package factorial;

public class HeavyFactorial extends Factorial {

    private long iterations;
    private int numberOfComputeCalls = 0 ;

    // Constructor sin parámetro: Le pone iterations = 1000000 por defecto
    public HeavyFactorial() {
        this(1000000);
    }
    // Contructor con parámetro: Establece iterations = parámetro de entrada
    public HeavyFactorial(long iterations) {
        this.iterations = iterations;
    }

    @Override
    public long computar(int value) {
        for (long i = 0; i < iterations; i++) {
            double dummy = Math.sin(2.352 + i) * Math.cos(i - 0.235);
        }
        numberOfComputeCalls += 1 ;
        return super.computar(value);
    }

    public int getNumberOfComputeCalls() {
        return numberOfComputeCalls ;
    }
}