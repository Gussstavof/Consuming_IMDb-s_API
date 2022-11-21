package model;

public class Movie {
    private String title;
    private String year;
    private String image;
    private String imDbRating;

    public Movie( String title, String year, String image, String imDbRating) {
        this.title = title;
        this.year = year;
        this.image = image;
        this.imDbRating = imDbRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", image='" + image + '\'' +
                ", imDbRating='" + imDbRating + '\'' +
                '}';
    }
}
