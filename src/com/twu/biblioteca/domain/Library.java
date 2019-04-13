package com.twu.biblioteca.domain;

import com.twu.biblioteca.parser.BookParser;
import com.twu.biblioteca.parser.MovieParser;
import com.twu.biblioteca.parser.UserParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<LibraryItems> libraryItems = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public Library() {

        BookParser bookParser = new BookParser();
        MovieParser movieParser = new MovieParser();
        UserParser userParser = new UserParser();

        libraryItems.addAll(bookParser.getBookList());
        libraryItems.addAll(movieParser.getMovieList());
        users.addAll(userParser.getUserList());
    }

    public LibraryItems getLibraryItemsByIndex(int libraryItemIndex, LibraryItems libraryItem) throws IndexOutOfBoundsException, NumberFormatException{
        for (LibraryItems li: libraryItems) {
            if ((li.getId() == libraryItemIndex) && libraryItem.getClass().equals(li.getClass())){
                return li;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public List<LibraryItems> getAvailableLibraryItemsList() {
        return libraryItems.stream().filter(LibraryItems::isAvailable).collect(Collectors.toList());
    }

    public List<LibraryItems> getLibraryItemsList() {
        return libraryItems.stream().collect(Collectors.toList());
    }

    public List<User> getUsersList() {
        return users.stream().collect(Collectors.toList());
    }

    public User getUserByLibraryUser(String libraryUser){
        return users.stream().filter(user -> user.getLibraryLogin().equals(libraryUser)).collect(Collectors.toList()).get(0);
    }

}
