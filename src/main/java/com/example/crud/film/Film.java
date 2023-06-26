package com.example.crud.film;

import jakarta.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "film_id")
    private int filmId;

    private String title;

    private String description;

    private int length;

    @Column(name = "release_year")
    private Integer releaseYear;

    private String rating;

    public int getFilmId() {
        return filmId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getLength() {
        return length;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setFilmId(int film_id) {
        this.filmId = film_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
