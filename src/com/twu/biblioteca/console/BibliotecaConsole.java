package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.LibraryItems;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.domain.User;
import com.twu.biblioteca.service.LibraryService;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.service.Login;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaConsole {

    private LibraryService library;
    private HashMap<String, String> loans = new HashMap<>();
    private User user;

    public BibliotecaConsole() {
        this.library = new LibraryService();
    }

    public String checkoutLibraryItems(String libraryItemIndex, LibraryItems libraryItem) {
        boolean checkoutSucceed;

        if (user == null){
            return "You need Login!";
        }

        try {
            LibraryItems item = library.getLibrary().getLibraryItemsByIndex(Integer.parseInt(libraryItemIndex), libraryItem);

            checkoutSucceed = library.checkoutLibraryItems(item);
            loans.put(item.getId() + " - " + item.getName(), user.getLibraryLogin());
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

    public String getLoans() {
        if (user.getRole().equals("librarian")){
            return loans.toString() + "\n";
        }
        return "You are not a librarian";
    }

    public String getUserRole(){
        return user.getRole();
    }

    public boolean Login(String username, String password){
        Login login = new Login();
        if (login.Authenticate(username, password)){
            this.user = library.getLibrary().getUserByLibraryUser(username);
            return true;
        }
        return false;
    }

    public String returnBook(String libraryIndex, LibraryItems libraryItem) {
        boolean returnSucceed;

        if (user == null){
            return "You need Login!";
        }

        try {
            LibraryItems item = library.getLibrary().getLibraryItemsByIndex(Integer.parseInt(libraryIndex), libraryItem);

            returnSucceed = library.returnLibraryItem(item);
            loans.remove(item.getId() + " - " + item.getName());
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            return "Please, enter a valid item index!\n";
        }

        if (returnSucceed) {
            return "Thank you for returning the item!\n";
        }

        return "That is not a valid item to return.\n";
    }
}
