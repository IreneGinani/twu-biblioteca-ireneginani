package com.twu.biblioteca.service;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.util.List;

public class LibraryService {

    private Library library = new Library();
    private List<Book> books = library.getBookList();


    public boolean checkoutBook(Book book) {
        return changeBookAvailability(book, false);
    }


    public boolean changeBookAvailability(Book book, boolean availability){

        for (int i = 0; i < books.size(); i++) {
            Book currentBook = books.get(i);

            if (book.equals(currentBook) && (currentBook.isAvailable()==!availability)) {
                currentBook.setAvailable(availability);

                return true;
            }
        }

        return false;

    }

    public boolean returnBook(Book book) {
        return changeBookAvailability(book, true);
    }

    public Library getLibrary(){ return library; }

}
