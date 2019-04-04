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

    public String processOption(int option) {
        StringBuffer sb = new StringBuffer();

        if (option == 1) {
            sb.append("Title - Author - Year\n");

            for (Book book : library.getBookList()) {
                sb.append(book.getTitle() + " - " + book.getAuthor() + " - " + book.getYear() + "\n");
            }
        } else {
            sb.append("Please select a valid option!");
        }

        return sb.toString();
    }

    private Library library;
}
