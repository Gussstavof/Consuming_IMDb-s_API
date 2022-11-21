package util;

import model.Movie;

import java.net.http.HttpResponse;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieUtil {

    public static List<String> toStringList(HttpResponse<String> httpResponse){
        Matcher matcher = Pattern.compile(".*\\[(.*)].*").matcher(httpResponse.body());
        matcher.find();
        return new ArrayList<>(Arrays.asList(matcher.group(0).split("},\\{")));
    }

    public static List<Movie> parseJsonMovie(List<String> stringMovies){
        List<Movie> movies = new LinkedList<>();

        for (String stringMovie : stringMovies) {
            var arrays = stringMovie.split("\",");
            String[] fields = {"\"id\"", "\"rank\"", "\"title\"", "\"fullTitle\"", "\"year\"", "\"image\"",
                    "\"crew\"", "\"imDbRating\"", "\"imDbRatingCount\""};
            for (int x = 0; x < fields.length; x++) {
                arrays[x] = arrays[x].replace(fields[x] + ":", "");
                arrays[x] = arrays[x].substring(1);
            }
            movies.add(new Movie(arrays[2], arrays[4], arrays[5], arrays[7]));
        }
        return movies;
    }

}
