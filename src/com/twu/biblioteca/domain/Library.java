package com.twu.biblioteca.domain;

import com.twu.biblioteca.parser.BookParser;
import com.twu.biblioteca.parser.MovieParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<LibraryItems> libraryItems = new ArrayList<>();

    public Library() {

        BookParser bookParser = new BookParser();
        MovieParser movieParser = new MovieParser();

        libraryItems.addAll(bookParser.getBookList());
        libraryItems.addAll(movieParser.getMovieList());
    }

        return libraryItems.get(bookIndex);
    public LibraryItems getLibraryItemsByIndex(int libraryItemIndex, LibraryItems libraryItem) throws IndexOutOfBoundsException, NumberFormatException{
    }

    public List<LibraryItems> getAvailableLibraryItemsList() {
        return libraryItems.stream().filter(LibraryItems::isAvailable).collect(Collectors.toList());
    }

    public List<LibraryItems> getLibraryItemsList() {
        return libraryItems.stream().collect(Collectors.toList());
    }

}
