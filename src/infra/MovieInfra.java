package infra;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieInfra {

    private HttpRequest requestMovies(String apiKeY) throws Exception {
        return HttpRequest.newBuilder()
                .uri(new URI("https://imdb-api.com/en/API/Top250Movies/"+apiKeY+"/"))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .build();
    }

    public HttpResponse<String> responseMovies(String apiKeY) throws Exception {
        return HttpClient.newHttpClient()
                .send(requestMovies(apiKeY), HttpResponse.BodyHandlers.ofString());
    }

}
