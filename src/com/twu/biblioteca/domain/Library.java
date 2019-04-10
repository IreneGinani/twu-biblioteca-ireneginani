package com.twu.biblioteca.domain;

import com.twu.biblioteca.parser.BookParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private BookParser bookParser = new BookParser();
    private List<Book> books = bookParser.getBookList();

    public Library() throws FileNotFoundException { }

    public Book getBookByIndex(int bookIndex) {
        return books.get(bookIndex);
    }

    public List<Book> getAvailableBookList() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public List<Book> getBookList() {
        return books.stream().collect(Collectors.toList());
    }

}
