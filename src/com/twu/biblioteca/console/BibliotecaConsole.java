package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

public class BibliotecaConsole {

    public BibliotecaConsole(Library library) {
        this.library = library;
    }

    public String getMainMenu() {
        return "Choose an option:\n" +
                "(1) List of Books\n" +
                "(0) Quit\n";
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String processOption(String option) {
        if (option.equals("0")) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        if (option.equals("1")) {
            sb.append("Title - Author - Year\n");

            for (Book book : library.getBookList()) {
                sb.append(book.getTitle()).append(" - ").append(book.getAuthor()).append(" - ").append(book.getYear()).append("\n");
            }
        } else if (option.equals("2")) {
            sb.append("Thank you! Enjoy the book!\n");
        } else {
            sb.append("Please select a valid option!\n");
        }

        return sb.toString();
    }

    private Library library;
}
