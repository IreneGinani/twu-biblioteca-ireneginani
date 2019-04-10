package com.twu.biblioteca.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    public Library() {
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book(1 , "Homo Deus", "Harari", 2015);
        Book sapiens = new Book(2, "Sapiens", "Harari", 2011);

        books = new ArrayList<>(Arrays.asList(harryPotter, homoDeus, sapiens));
    }

    public boolean checkoutBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);

            if (book.equals(currentBook) && currentBook.isAvailable()) {
                currentBook.setAvailable(false);

                return true;
            }
        }

        return false;
    }

    public Book getBookByIndex(int bookIndex) {
        return books.get(bookIndex);
    }

    public List<Book> getBookList() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public boolean returnBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);

            if (book.equals(currentBook) && !currentBook.isAvailable()) {
                currentBook.setAvailable(true);

                return true;
            }
        }

        return false;
    }

    private List<Book> books;
}
