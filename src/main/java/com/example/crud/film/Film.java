package com.example.crud.film;

import jakarta.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int film_id;

    private String title;

    private String description;

    private int length;

    @Column(name = "release_year")
    private String releaseYear;

    private String rating;

    public int getFilm_id() {
        return film_id;
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getRating() {
        return rating;
    }
}
