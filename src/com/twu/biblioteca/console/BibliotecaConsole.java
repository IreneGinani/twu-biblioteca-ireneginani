package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.util.List;

public class BibliotecaConsole {

    public BibliotecaConsole(Library library) {
        this.library = library;
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public List<Book> processOption(int option) {
        return library.getBookList();
    }

    private Library library;
}
