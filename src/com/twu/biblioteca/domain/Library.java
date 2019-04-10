package com.twu.biblioteca.domain;

import com.twu.biblioteca.parser.BookParser;

import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private BookParser bookParser = new BookParser();
    private List<Book> books = bookParser.getBookList();

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
