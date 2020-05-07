package streamOperations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(7, 3, 4, 2, 6, 6, 10, 9, 10, 11, 10, 13, 5, 1);

        double count = numbers.stream().count();
        int max = numbers.stream().max((a, b) -> a.compareTo(b)).get();
        int min = numbers.stream().min(Comparator.naturalOrder()).get();
        int firstElement = numbers.stream().findFirst().get();

        System.out.println("Count: " + count);
        System.out.println("Max:   " + max);
        System.out.println("Min:   " + min);
        System.out.println("First: " + firstElement);

        List<Integer> distinctNumbers = numbers
                .stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.print("Unique values: ");
        distinctNumbers.forEach(number -> {
            System.out.printf("%d ", number);
        });
        System.out.println() ;

        System.out.print("Sorted values: ");
        numbers.stream()
                .sorted()
                .forEach(number -> System.out.print(number + " "));
        System.out.println() ;

        System.out.print("Sorted values in descending order: ");
        numbers.stream()
                .sorted((Comparator<Integer>)Comparator.naturalOrder().reversed())
                .forEach(number -> System.out.print(number + " "));
    }
}
