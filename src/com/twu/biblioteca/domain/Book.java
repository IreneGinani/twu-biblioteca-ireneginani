package com.twu.biblioteca.domain;

import java.util.Objects;

public class Book extends LibraryItems{

    private String author;
    private int id;
    private int year;

    public Book(int id, String title, String author, int year) {
        super(title, true);
        this.author = author;
        this.id = id;
        this.year = year;

    }

    public Book() {
        super(new String(), true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(id)
                .append(" - ")
                .append(getName())
                .append(" - ")
                .append(author)
                .append(" - ")
                .append(year)
                .append("\n");

        return sb.toString();
    }
}
