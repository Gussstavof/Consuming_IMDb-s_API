import infra.MovieInfra;
import util.MovieUtil;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        MovieInfra movieInfra = new MovieInfra();

        Scanner scanner = new Scanner(System.in);
        System.out.println("ApiKey: ");
        String apiKey = scanner.next();

        var response = movieInfra.responseMovies(apiKey);

        List<String> stringMovies = MovieUtil.toStringList(response);
        var movies = MovieUtil.parseJsonMovie(stringMovies);

        movies.forEach(System.out::println);
    }
}
