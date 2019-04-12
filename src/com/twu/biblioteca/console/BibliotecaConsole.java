package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.LibraryItems;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.service.Login;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BibliotecaConsole {

    private LibraryService library;
    private HashMap<String, String> loans = new HashMap<String, String>();
    private String username;

    public BibliotecaConsole() {
        this.library = new LibraryService();
    }

    public String checkoutLibraryItems(String libraryItemIndex, LibraryItems libraryItem) {
        boolean checkoutSucceed;

        try {
            LibraryItems item = library.getLibrary().getLibraryItemsByIndex(Integer.parseInt(libraryItemIndex), libraryItem);

            checkoutSucceed = library.checkoutLibraryItems(item);
            loans.put(username, item.getId() + " - " + item.getName());
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid item index!\n";
        }

        if (checkoutSucceed) {
            return "Thank you! Enjoy the item!\n";
        }

        return "Sorry, that item is not available!\n";
    }

    public String getFormattedLibraryItemsList(LibraryItems libraryItems) {
        StringBuilder sb = new StringBuilder();
        List<LibraryItems> libraryItemsList;

        if (libraryItems instanceof Book){
            sb.append("Index - Title - Author - Year\n");

            libraryItemsList = library.getLibrary().getAvailableLibraryItemsList().stream().filter(b -> b instanceof Book).collect(Collectors.toList());
        } else {
            sb.append("Index - Title - Director - Year - Rating\n");

            libraryItemsList = library.getLibrary().getAvailableLibraryItemsList().stream().filter(b -> b instanceof Movie).collect(Collectors.toList());
        }
            for (int i = 0; i < libraryItemsList.size(); i++) {
                LibraryItems libraryItem = libraryItemsList.get(i);

                sb.append(libraryItem.toString());
            }

        return sb.toString();
    }

    public HashMap<String, String> getLoans() {
        return loans;
    }

    public boolean Login(String username, String password){
        Login login = new Login();
        this.username = username;
        return login.Authenticate(username, password);
    }

    public String returnBook(String libraryIndex, LibraryItems libraryItem) {
        boolean returnSucceed;

        try {
            returnSucceed = library.returnLibraryItem(library.getLibrary().getLibraryItemsByIndex(Integer.parseInt(libraryIndex), libraryItem));
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid item index!\n";
        }

        if (returnSucceed) {
            return "Thank you for returning the item!\n";
        }

        return "That is not a valid item to return.\n";
    }
}
