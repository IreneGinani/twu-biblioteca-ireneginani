package com.twu.biblioteca.domain;

import java.util.Objects;

public class Movie extends LibraryItems{

    private String director;
    private String rating;
    private int year;

    public Movie(int id, String title, String director, int year, String rating) {
        super(id, title, true);
        this.director = director;
        this.year = year;
        this.rating = rating;

        setAvailable(true);
    }

    public Movie() {
        super(0, new String(), true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return getId() == movie.getId();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getId())
                .append(" - ")
                .append(getName())
                .append(" - ")
                .append(director)
                .append(" - ")
                .append(year)
                .append(" - ")
                .append(rating)
                .append("\n");

        return sb.toString();
    }
}
