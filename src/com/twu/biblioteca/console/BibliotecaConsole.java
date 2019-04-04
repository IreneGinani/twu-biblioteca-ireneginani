package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;

import java.util.Arrays;
import java.util.List;

public class BibliotecaConsole {

    public List<Book> getBookList() {
        Book harryPotter = new Book("Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book("Homo Deus", "Harari", 2015);
        Book sapiens = new Book("Sapiens", "Harari", 2011);

        return Arrays.asList(harryPotter, homoDeus, sapiens);
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<Book> processOption(int option) {
        return null;
    }
}
