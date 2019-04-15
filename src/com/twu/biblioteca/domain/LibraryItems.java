package com.twu.biblioteca.domain;

import com.twu.biblioteca.parser.BookParser;
import com.twu.biblioteca.parser.MovieParser;

public abstract class LibraryItems {

    private boolean available;
    private String name;
    private int id;

    public LibraryItems(int id, String name, boolean available) {
        this.available = available;
        this.name = name;
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getName() {
        return name;
    }

    public int getId() { return id; }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
