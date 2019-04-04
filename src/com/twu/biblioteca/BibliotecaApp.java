package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole();

        System.out.println(bibliotecaConsole.getWelcomeMessage());

        for (String book: bibliotecaConsole.getBookList()) {
            System.out.println(book);
        }

    }
}
