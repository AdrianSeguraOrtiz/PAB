package factorial;

public class HeavyFactorial extends Factorial {
    private int numberOfComputeCalls = 0;

    @Override
    public long computar(int value) {
        for (long i = 0; i < 500000; i++) {
            double dummy = Math.sin(2.3 + i) * Math.cos(i);
        }

        numberOfComputeCalls += 1;

        return super.computar(value);
    }

    public int getNumberOfComputeCalls() {
        return numberOfComputeCalls;
    }
}

