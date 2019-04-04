package com.twu.biblioteca.domain;

import java.util.Arrays;
import java.util.List;

public class Library {

    public List<Book> getBookList() {
        Book harryPotter = new Book("Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book("Homo Deus", "Harari", 2015);
        Book sapiens = new Book("Sapiens", "Harari", 2011);

        return Arrays.asList(harryPotter, homoDeus, sapiens);
    }
}
