package edu.knoldus.model;

import java.util.*;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Operations {

    /**
     * this function will
     * generate random numbers list
     * @return
     */
    private List<Integer> generateRandomNumbersList() {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(rand.nextInt(100));
        }
        return list;
    }

    /**
     * this predicate will
     * check whether a number is prime
     * or not
     */
    private Predicate<Integer> isPrime = number -> {
        IntPredicate isDivisible = index -> number % index == 0;
        return number > 1 && IntStream.range(2, number - 1).noneMatch(isDivisible);
    };

    /**
     * Q.1
     * this function will return
     * prime number list
     * @return
     */
    public List<Integer> getPrimeNumbersList() {

        List<Integer> list = generateRandomNumbersList();
        Stream<Integer> integerStream = list.stream();
        List<Integer> primeNumbersList = integerStream.filter(isPrime)
                .collect(Collectors.toList());
        return primeNumbersList;
    }

    /**
     * Q.2
     * this function counts
     * words in a text file
     * @throws IOException
     */
    public static void countWordsFromFile() throws IOException {
        String filePath = "/home/knoldus/IdeaProjects/java8assignment01/src/main/resources/wordCountResourceFile.txt";
        System.out.println("word count of a file:");
        try (final Stream<String> lines = Files.lines(Paths.get(filePath))) {

            Map<String, Integer> map = lines.map(line -> line.split("[\\s]+"))
                    .flatMap(Arrays::stream).collect(groupingBy(Function.identity(), summingInt(number -> 1)));
            System.out.println(map);
        }
    }

    /**
     * Q.3
     * this function
     * counts words in sentence
     */
    public void countWordsInSentence() {

        String sentence = "My name is Vinisha Vinisha is my name";
        String[] words = sentence.split("\\s+");
        Stream<String> wordsStream = Stream.of(words);
        Map<String, Long> wordCount = wordsStream.map(String::toLowerCase).collect(groupingBy(word -> word, counting()));
        System.out.println("word count of a sentence:");
        List<List<Object>> wordFrequencyList = new LinkedList<>();
        wordCount.forEach((key, value) -> {
            wordFrequencyList.add(Arrays.asList(key, value));
        });
        System.out.println(wordFrequencyList);
    }

    /**
     * Q.4
     * this function multiplies
     * two lists
     * @param list1
     * @param list2
     */
    public void getListMultiplication(List<Integer> list1, List<Integer> list2) {
        if (list1.size() == list2.size()) {
            System.out.println("multiplication result of both lists:");
            IntStream.range(0, list1.size())
                    .map(position -> list1.get(position) * list2.get(position)).forEach(System.out::println);
        } else {
            System.out.println("both list have different size. Hence, can't multiply");
        }
    }

    /**
     * Q.5
     * this function gets
     * movie details
     */
    public void getMovieDetails() {
        List<edu.knoldus.model.Movie> movieList = new ArrayList<>();

        movieList.add(new edu.knoldus.model.Movie("Conjuring ", 2009, 6.0, "Horror"));
        movieList.add(new edu.knoldus.model.Movie("Dhamaal", 2003, 10.0, "Drama"));
        movieList.add(new edu.knoldus.model.Movie("Dumb n Dumber", 2004, 8.2, "Comedy"));
        movieList.add(new edu.knoldus.model.Movie("jaurassic park", 2001, 7.0, "Sci-Fi"));

        System.out.println("movies with rating more than 8 and genre comedy");
        movieList.stream().filter(movies -> movies.getRating() > 8 && movies.getGenre().equalsIgnoreCase("comedy"))
                .map(movie -> movie.getName()).forEach(System.out::println);

        System.out.println("movies with release year greater than 2000 and rating less than 8.");
        movieList.stream().filter(movies -> movies.getRating() < 8 && movies.getReleaseYear() > 2000)
                .map(movie -> movie.getName()).forEach(System.out::println);

        System.out.println("movies with rating as even number");
        movieList.stream().filter(movies -> movies.getRating() % 2 == 0)
                .map(movie -> movie.getName()).forEach(System.out::println);

        System.out.println("movies with rating equals to 7 and genre Sci-Fi");
        movieList.stream().filter(movies -> movies.getRating() == 7.0 && movies.getGenre().equalsIgnoreCase("Sci-Fi"))
                .map(movie -> movie.getName()).forEach(System.out::println);
    }
}