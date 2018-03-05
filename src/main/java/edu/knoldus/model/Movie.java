package edu.knoldus.model;

public class Movie {
    public String getName() {
        return name;
    }


    public Integer getReleaseYear() {
        return releaseYear;
    }


    public Double getRating() {
        return rating;
    }


    public String getGenre() {
        return Genre;
    }


    private String name;
    private Integer releaseYear;
    private Double rating;
    private String Genre;


    public Movie(String name, Integer releaseYear, Double rating, String Genre) {

        this.name = name;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.Genre = Genre;
    }
}
