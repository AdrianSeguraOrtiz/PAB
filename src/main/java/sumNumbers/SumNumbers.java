package sumNumbers;

import java.util.List;

public class SumNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13) ;

        long initTime = System.currentTimeMillis() ;

        double sum = numbers
                .stream()
                .reduce(0, (number1, number2) -> number1 + number2) ;

        long totalTime = System.currentTimeMillis() - initTime ;

        System.out.println("Total computing time: " + totalTime + " milliseconds") ;

        System.out.println("Sum " + sum) ;
    }
}