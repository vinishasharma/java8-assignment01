package edu.knoldus.application;

import edu.knoldus.model.Operations;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class OperationsCall {
    public static void main(String args[]) throws IOException {
        Operations operations = new Operations();
        //Q.1 Call
        List<Integer> primeNumbersList = operations.getPrimeNumbersList();
        System.out.println("prime numbers list:");
        primeNumbersList.forEach(System.out :: println);
        //Q.2 Call
        operations.countWordsFromFile();
        //Q.3 Call
        operations.countWordsInSentence();
        //Q.4 Call
        operations.getListMultiplication(Arrays.asList(1, 2, 3), Arrays.asList(5, 6, 7));
        //Q.5 Call
        operations.getMovieDetails();
    }
}
