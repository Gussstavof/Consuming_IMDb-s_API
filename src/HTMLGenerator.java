import model.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HTMLGenerator {
    private final Writer writer;

    public HTMLGenerator(Writer writer) {
        this.writer = writer;
    }

    public void generate(Collection<Movie> movies) throws IOException {

        generateHtml(movies);

        writer.append(generateHtml(movies));
    }

    private String generateHtml(Collection<Movie> movies) {
        return "<!DOCTYPE html>\n" +
               "  <html lang=\"en\">\n" +
               "    <head>\n" +
               "        <meta charset=\"UTF-8\">\n" +
               "        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
               "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
               "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\">\n" +
               "        <title>Document</title>\n" +
               "    </head>\n" +
               "    <body>\n"
               +
               moviesHtml(movies)
               +
               "</body>\n" +
               "</html>";
    }

    private Collection<String> moviesHtml(Collection<Movie> movies) {
        List<String> show = new ArrayList<>();
        for (Movie movie: movies) {
           show.add(    "<div class=\"card\" style=\"width: 18rem;\">\n" +
                        "  <img src=\""+movie.getImage()+"\" class=\"card-img-top\" alt=\"...\">\n" +
                        "  <div class=\"card-body\">\n" +
                        "    <h5 class=\"card-title\">"+movie.getTitle()+"</h5>\n" +
                        "    <p class=\"card-text\">"+movie.getImDbRating()+"</p>\n" +
                        "    <p class=\"card-text\">"+movie.getYear()+"</p>\n" +
                        "  </div>\n" +
                        "</div>\n");
        }

        return show;
    }


}
