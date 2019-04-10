package com.twu.biblioteca.parser;

import com.twu.biblioteca.domain.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookParser {

    public List<Book> getBookList() {

        Book harryPotter = new Book("Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book("Homo Deus", "Harari", 2015);
        Book sapiens = new Book("Sapiens", "Harari", 2011);

        List<Book> books = new ArrayList<>(Arrays.asList(harryPotter, homoDeus, sapiens));

        return books;
    }
}
