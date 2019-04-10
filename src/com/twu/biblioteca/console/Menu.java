package com.twu.biblioteca.console;

import sun.text.bidi.BidiLine;

import java.util.Scanner;

public class Menu {

    private BibliotecaConsole bibliotecaConsole = new BibliotecaConsole();


    public BibliotecaConsole getBibliotecaConsole(){ return bibliotecaConsole; }

    public String getMainMenu() {
        return "Choose an option:\n" +
                "(1) List of books\n" +
                "(2) Checkout a book\n" +
                "(3) Return a book\n" +
                "(0) Quit\n";
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String processOption(String option) {
        if (option.equals("0")) {
            return "";
        }

        if (option.equals("1")) {
            return bibliotecaConsole.getFormattedBookList();
        } else if (option.equals("2")) {
            System.out.println("Please, enter a book index");

            Scanner scan = new Scanner(System.in);
            String bookIndex = scan.next();

            return bibliotecaConsole.checkoutBook(bookIndex);
        } else if (option.equals("3")) {
            System.out.println("Please, enter a book index");

            Scanner scan = new Scanner(System.in);
            String bookIndex = scan.next();

            return bibliotecaConsole.returnBook(bookIndex);
        } else {
            return "Please select a valid option!\n";
        }
    }

}
