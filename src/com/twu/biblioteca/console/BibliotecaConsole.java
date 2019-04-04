package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

public class BibliotecaConsole {

    public BibliotecaConsole(Library library) {
        this.library = library;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public void processOption(int option) {

        System.out.println("Title - Author - Year");

        for (Book book: library.getBookList()) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " - " + book.getYear());
        }

    }

    private Library library;
}
