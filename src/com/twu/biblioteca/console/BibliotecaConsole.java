package com.twu.biblioteca.console;

import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.domain.Book;

import java.util.List;
import java.util.Scanner;

public class BibliotecaConsole {

    private LibraryService library;

    public BibliotecaConsole() {
        this.library = new LibraryService();
    }

    public String checkoutBook(String bookIndex) {
        boolean checkoutSucceed;

        try {
            checkoutSucceed = library.checkoutBook(library.getLibrary().getBookByIndex(Integer.parseInt(bookIndex)));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid book index!\n";
        }

        if (checkoutSucceed) {
            return "Thank you! Enjoy the book!\n";
        }

        return "Sorry, that book is not available!\n";
    }

    public String getFormattedBookList() {
        StringBuilder sb = new StringBuilder();

        sb.append("Index - Title - Author - Year\n");

        List<Book> bookList = library.getLibrary().getAvailableBookList();

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);

            sb.append(book.toString());
        }

        return sb.toString();
    }


    public String returnBook(String bookIndex) {
        boolean returnSucceed;

        try {
            returnSucceed = library.returnBook(library.getLibrary().getBookByIndex(Integer.parseInt(bookIndex)));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid book index!\n";
        }

        if (returnSucceed) {
            return "Thank you for returning the book!\n";
        }

        return "That is not a valid book to return.\n";
    }
}
