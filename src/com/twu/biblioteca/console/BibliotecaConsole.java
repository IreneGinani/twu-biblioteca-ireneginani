package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

public class BibliotecaConsole {

    public BibliotecaConsole(Library library) {
        this.library = library;
    }

    public String getFormattedBookList() {
        StringBuilder sb = new StringBuilder();

        sb.append("Title - Author - Year\n");

        for (Book book : library.getBookList()) {
            sb.append(book.getTitle()).append(" - ").append(book.getAuthor()).append(" - ").append(book.getYear()).append("\n");
        }

        return sb.toString();
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
            return "";
        }

        if (option.equals("1")) {
            return getFormattedBookList();
        } else if (option.equals("2")) {
            return "Thank you! Enjoy the book!\n";
        } else {
            return "Please select a valid option!\n";
        }
    }

    private Library library;
}
