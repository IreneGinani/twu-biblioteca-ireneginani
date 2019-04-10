package com.twu.biblioteca.domain;

import java.util.Objects;

public class Book {

    private String author;
    private boolean available;
    private int id;
    private String title;
    private int year;

    public Book(int id, String title, String author, int year) {
        this.author = author;
        this.id = id;
        this.title = title;
        this.year = year;

        available = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) &&
                Objects.equals(available, book.available) &&
                Objects.equals(title, book.title) &&
                Objects.equals(year, book.year);
    }

    public String getAuthor() { return author; }

    public int getId() { return id; }

    public String getTitle() { return title; }

    public int getYear() { return year; }

    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
