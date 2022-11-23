import infra.MovieInfra;
import model.Movie;
import util.MovieUtil;

import java.io.*;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ApiKey: ");
        String apiKey = scanner.next();

        List<Movie> movies = MovieUtil
                .parseJsonMovie(new MovieInfra().responseMovies(apiKey));

        Writer printWriter = new PrintWriter("index.html");
        new HTMLGenerator(printWriter)
               .generate(movies);

      //  movies.forEach(System.out::println);
    }
}
