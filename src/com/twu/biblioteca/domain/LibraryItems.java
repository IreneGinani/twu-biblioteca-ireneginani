package com.twu.biblioteca.domain;

import com.twu.biblioteca.parser.BookParser;
import com.twu.biblioteca.parser.MovieParser;

public abstract class LibraryItems {

    private boolean available;
    private String name;

    public LibraryItems(String name, boolean available) {
        this.available = available;
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getName() {
        return name;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
