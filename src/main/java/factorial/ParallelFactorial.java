package factorial;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.currentTimeMillis;

public class ParallelFactorial {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        List<Long> factorialValues;
        HeavyFactorial factorial = new HeavyFactorial();

        long initTime = currentTimeMillis();

        // Forma tradicional: For (secuencial)

        //for (int i : numbers){
        //System.out.println(factorial.computar(i));
        //}

        // Nuevo: Stream o StreamParallel (secuencial o paralelo)

        factorialValues = numbers
                .parallelStream()  // .stream() para hacerlo secuencial. Ejecutamos primero una y después
                                   // otra para comparar el tiempo de ejecución y CPU. Paralelo es más
                                   // rápido pero tiene un mayor pico de CPU, ya que usa todos los cores.
                .map(factorial::computar)
                .collect(Collectors.toList());

        long totalTime = currentTimeMillis() - initTime;

        System.out.println("Total computing time: " + totalTime + " milliseconds");

        for (int i = 0; i < numbers.size(); i++) {
            System.out.println(numbers.get(i) + ": " + factorialValues.get(i));
        }

        // Si hacemos Parallel Stream nos podemos encontrar el problema de que dentro del método computar
        // de HeavyFactorial al hacer la operación numberOfComputeCalls += 1 se lea la variable antes
        // de la última escritura. Por lo que a lo mejor nos salen menos número de llamadas de las que
        // nos esperábamos.

        System.out.println("Number of factorial.compute() operations: " + factorial.getNumberOfComputeCalls());
    }
}
