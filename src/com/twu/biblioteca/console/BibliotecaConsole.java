package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.LibraryItems;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.domain.Book;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaConsole {

    private LibraryService library;

    public BibliotecaConsole() {
        this.library = new LibraryService();
    }

    public String checkoutLibraryItems(String bookIndex) {
        boolean checkoutSucceed;

        try {
            checkoutSucceed = library.checkoutLibraryItems(library.getLibrary().getLibraryItemsByIndex(Integer.parseInt(bookIndex)));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid book index!\n";
        }

        if (checkoutSucceed) {
            return "Thank you! Enjoy the book!\n";
        }

        return "Sorry, that book is not available!\n";
    }

    public String getFormattedLibraryItemsList(LibraryItems libraryItems) {
        StringBuilder sb = new StringBuilder();
        List<LibraryItems> libraryItemsList;

        if (libraryItems instanceof Book){
            sb.append("Index - Title - Author - Year\n");

            libraryItemsList = library.getLibrary().getAvailableLibraryItemsList().stream().filter(b -> b instanceof Book).collect(Collectors.toList());
        } else {
            sb.append("Index - Title - Author - Year\n");

            libraryItemsList = library.getLibrary().getAvailableLibraryItemsList().stream().filter(b -> b instanceof Movie).collect(Collectors.toList());
        }
            for (int i = 0; i < libraryItemsList.size(); i++) {
                LibraryItems libraryItem = libraryItemsList.get(i);

                sb.append(libraryItem.toString());
            }

        return sb.toString();
    }

    public String returnBook(String bookIndex) {
        boolean returnSucceed;

        try {
            returnSucceed = library.returnLibraryItem(library.getLibrary().getLibraryItemsByIndex(Integer.parseInt(bookIndex)));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid book index!\n";
        }

        if (returnSucceed) {
            return "Thank you for returning the book!\n";
        }

        return "That is not a valid book to return.\n";
    }
}
