package sumNumbers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumNumbersWithCriticalSection {
    public static void main(String[] args) throws IOException {
        long initTime = System.currentTimeMillis() ;

        int numberOfMaps = 0 ;

        double sum = Files
                .lines(Paths.get("data/numbers.txt"))
                .parallel()
                .map(line -> {
                    //numberOfMaps = numberOfMaps + 1 ;  //Pasa igual que antes se corre el riesgo de una
                                                         // lectura antes de la última actualización, por eso
                                                         // ni si quiera te deja escribirlo.
                    return Integer.valueOf(line);
                })
                .reduce(0, (number1, number2) -> number1 + number2) ;

        long totalTime = System.currentTimeMillis() - initTime ;

        System.out.println("Total computing time: " + totalTime + " milliseconds") ;

        System.out.println("Sum " + sum) ;
    }
}
