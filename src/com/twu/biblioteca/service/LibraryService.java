package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import com.twu.biblioteca.domain.LibraryItems;

import java.util.List;

public class LibraryService {

    private Library library = new Library();
    private List<LibraryItems> LibraryItems = library.getLibraryItemsList();


    public boolean checkoutLibraryItems(LibraryItems LibraryItem) {
        return changeLibraryItemAvailability(LibraryItem, false);
    }


    public boolean changeLibraryItemAvailability(LibraryItems libraryItem, boolean availability){

        for (int i = 0; i < LibraryItems.size(); i++) {
            LibraryItems currentLibraryItem = LibraryItems.get(i);

            if (libraryItem.equals(currentLibraryItem) && (currentLibraryItem.isAvailable()==!availability)) {
                currentLibraryItem.setAvailable(availability);
                return true;
            }
        }

        return false;

    }

    public boolean returnLibraryItem(LibraryItems LibraryItem) {
        return changeLibraryItemAvailability(LibraryItem, true);
    }

    public Library getLibrary(){ return library; }

}
