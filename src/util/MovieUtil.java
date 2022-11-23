package util;

import model.Movie;

import java.net.http.HttpResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieUtil {
    public static List<Movie> parseJsonMovie(HttpResponse<String> httpResponse){
        List<Movie> movies = new LinkedList<>();
        List<String> stringMovies = toStringList(httpResponse);

        for (String stringMovie : stringMovies) {
            var movie = getResultOfElement(stringMovie.split("\","));
            movies.add(new Movie(movie[2], movie[4], movie[5], movie[7]));
        }
        return movies;
    }

    private static List<String> toStringList(HttpResponse<String> httpResponse){
        Matcher matcher = Pattern.compile(".*\\[(.*)].*").matcher(httpResponse.body());
        matcher.find();
        return new ArrayList<>(Arrays.asList(matcher.group(0).split("},\\{")));
    }

    private static String[] getResultOfElement(String[] arrays){
        String[] fields = {"\"id\"", "\"rank\"", "\"title\"", "\"fullTitle\"", "\"year\"", "\"image\"",
                "\"crew\"", "\"imDbRating\"", "\"imDbRatingCount\""};
        for (int x = 0; x < fields.length; x++) {
            arrays[x] = arrays[x].replace(fields[x] + ":", "");
            arrays[x] = arrays[x].substring(1);
        }
        return arrays;
   }
}
