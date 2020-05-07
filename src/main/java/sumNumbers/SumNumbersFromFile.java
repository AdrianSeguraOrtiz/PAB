package sumNumbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumNumbersFromFile {
    public static void main(String[] args) throws IOException {
        long initTime = System.currentTimeMillis() ;

        double sum = Files
                .lines(Paths.get("data/manyNumbers.txt"))
                .parallel()
                .map(Integer::valueOf)
                .reduce(0, (number1, number2) -> number1 + number2) ;

        long totalTime = System.currentTimeMillis() - initTime ;

        System.out.println("Total computing time: " + totalTime + " milliseconds") ;

        System.out.println("Sum " + sum) ;
    }
}
