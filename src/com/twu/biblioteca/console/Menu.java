package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.domain.OptionsEnum;

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
        if (option.equals(OptionsEnum.EXIT.value)) {
            return "";
        }

        if (option.equals(OptionsEnum.BookList.value)) {
            return bibliotecaConsole.getFormattedLibraryItemsList(new Book());
        } else if (option.equals(OptionsEnum.CheckoutBook.value)) {
            System.out.println("Please, enter a book index");

            Scanner scan = new Scanner(System.in);
            String bookIndex = scan.next();

            return bibliotecaConsole.checkoutLibraryItems(bookIndex);
        } else if (option.equals(OptionsEnum.ReturnBook.value)) {
            System.out.println("Please, enter a book index");

            Scanner scan = new Scanner(System.in);
            String bookIndex = scan.next();

            return bibliotecaConsole.returnBook(bookIndex);
        } else if (option.equals(OptionsEnum.MovieList.value)) {
            return bibliotecaConsole.getFormattedLibraryItemsList(new Movie());
        } else{
            return "Please select a valid option!\n";
        }
    }

}
