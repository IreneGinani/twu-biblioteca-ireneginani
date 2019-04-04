package com.twu.biblioteca;

import com.twu.biblioteca.console.BibliotecaConsole;
import com.twu.biblioteca.domain.Book;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole();

        System.out.println(bibliotecaConsole.getWelcomeMessage());

        System.out.println("Title - Author - Year");

        for (Book book: bibliotecaConsole.getBookList()) {
            System.out.println(book.getTitle() + " - " + book.getAuthor() + " - " + book.getYear());
        }
    }
}
