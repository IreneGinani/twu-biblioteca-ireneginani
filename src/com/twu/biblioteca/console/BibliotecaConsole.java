package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.util.List;
import java.util.Scanner;

public class BibliotecaConsole {

    public BibliotecaConsole(Library library) {
        this.library = library;
    }

    public String checkoutBook(String bookIndex) {
        boolean output;

        try {
            output = library.checkoutBook(library.getBookByIndex(Integer.parseInt(bookIndex)));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid book index!\n";
        }

        if (output) {
            return "Thank you! Enjoy the book!\n";
        }

        return "Sorry, that book is not available!\n";
    }

    public String getFormattedBookList() {
        StringBuilder sb = new StringBuilder();

        sb.append("Index - Title - Author - Year\n");

        List<Book> bookList = library.getBookList();

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);

            sb.append(i)
                .append(" - ")
                .append(book.getTitle())
                .append(" - ")
                .append(book.getAuthor())
                .append(" - ")
                .append(book.getYear())
                .append("\n");
        }

        return sb.toString();
    }

    public String getMainMenu() {
        return "Choose an option:\n" +
                "(1) List of books\n" +
                "(2) Checkout a book\n" +
                "(3) Return a book\n" +
                "(4) List of movies\n" +
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
            return getFormattedBookList();
        } else if (option.equals("2")) {
            System.out.println("Please, enter a book index");

            Scanner scan = new Scanner(System.in);
            String bookIndex = scan.next();

            return checkoutBook(bookIndex);
        } else if (option.equals("3")) {
            System.out.println("Please, enter a book index");

            Scanner scan = new Scanner(System.in);
            String bookIndex = scan.next();

            return returnBook(bookIndex);
        } else if (option.equals("4")) {
            return "Index - Name - Year - Director - Rating\n" +
                    "0 - Harry Potter and The Sorcerer's Stone - 2008 - David Yates - 10\n" +
                    "1 - Harry Potter and Chamber of Secrets - 2005 - David Yates - Unrating\n";
        } else {
            return "Please select a valid option!\n";
        }
    }

    private Library library;

    public String returnBook(String bookIndex) {
        boolean output;

        try {
            output = library.returnBook(library.getBookByIndex(Integer.parseInt(bookIndex)));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid book index!\n";
        }

        if (output) {
            return "Thank you for returning the book!\n";
        }

        return "That is not a valid book to return.\n";
    }
}
