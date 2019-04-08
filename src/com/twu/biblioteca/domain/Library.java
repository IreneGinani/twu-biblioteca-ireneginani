package com.twu.biblioteca.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    public Library() {
        Book harryPotter = new Book("Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book("Homo Deus", "Harari", 2015);
        Book sapiens = new Book("Sapiens", "Harari", 2011);

        books = Arrays.asList(harryPotter, homoDeus, sapiens);
    }

    public boolean checkoutBook(Book book) {
        book.setAvailable(false);

        return true;
    }

    public List<Book> getBookList() {
        return books.stream().filter(book -> book.isAvailable()).collect(Collectors.toList());
    }

    private List<Book> books;
}
