package com.twu.biblioteca.domain;

import java.util.Objects;

public class Movie extends LibraryItems{

    private String director;
    private int id;
    private String rating;
    private int year;

    public Movie(int id, String title, String director, int year, String rating) {
        super(title, true);
        this.id = id;
        this.director = director;
        this.year = year;
        this.rating = rating;

        setAvailable(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id;
    }

}
