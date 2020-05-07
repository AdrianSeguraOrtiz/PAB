package factorial;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelFactorialWithFilter {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) ;
        List<List<Long>> factorialValues ;
        HeavyFactorial factorial = new HeavyFactorial() ;

        long initTime = System.currentTimeMillis() ;

        factorialValues = numbers
                .parallelStream()
                .filter(number -> number%2 == 0)  // Solo pasan a map los números pares de la lista
                .map(number -> {
                    System.out.println(number);
                    return List.of(Long.valueOf(number), factorial.computar(number)) ;})
                .collect(Collectors.toList());

        long totalTime = System.currentTimeMillis() - initTime ;

        System.out.println("Total computing time: " + totalTime + " milliseconds") ;

        Comparator<List<Long>> comparator = Comparator.comparing(pair -> pair.get(0));

        factorialValues
                .stream()
                .sorted(comparator.reversed())
                .forEach(pair -> System.out.println(pair.get(0) + ": " + pair.get(1)));
    }
}
