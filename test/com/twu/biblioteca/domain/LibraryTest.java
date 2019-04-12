package com.twu.biblioteca.domain;

import com.twu.biblioteca.service.LibraryService;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class LibraryTest {

    LibraryService library;

    @Before
    public void initialization(){
        library = new LibraryService();
    }

    @Test
    public void shouldReturnFalseWhenCheckoutSameBookTwice() {
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        library.checkoutLibraryItems(harryPotter);

        assertFalse(library.checkoutLibraryItems(harryPotter));
    }

    @Test
    public void shouldReturnFalseWhenCheckoutNonExistingBook() {
        Book harryPotter = new Book(0, "Harry Potter and Chamber of Secrets", "J.K Rowling", 1998);

        library.checkoutLibraryItems(harryPotter);

        assertFalse(library.checkoutLibraryItems(harryPotter));
    }

    @Test
    public void shouldReturnListOfAllBooks() {
        List<String> expectedBookTitleList =
                Arrays.asList("Harry Potter and The Sorcerer's Stone",  "Homo Deus", "Sapiens");

        List<String> actualBookTitleList =
                library.getLibrary().getLibraryItemsList().stream().filter(book -> book instanceof Book).map(LibraryItems::getName).collect(Collectors.toList());

        assertEquals(expectedBookTitleList, actualBookTitleList);
    }

    @Test
    public void shouldReturnListOfAllBooksWithTitleAuthorAndPublication(){
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book(1 , "Homo Deus", "Harari", 2015);
        Book sapiens = new Book(2, "Sapiens", "Harari", 2011);

        List<Book> bookList = Arrays.asList(harryPotter, homoDeus, sapiens);

        assertEquals(bookList, library.getLibrary().getLibraryItemsList().stream().filter(book -> book instanceof Book).collect(Collectors.toList()));
    }

    @Test
    public void shouldReturnTheListOfAvailableBooks(){
       Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        library.checkoutLibraryItems(harryPotter);

        List<LibraryItems> bookList = library.getLibrary().getAvailableLibraryItemsList().stream().filter(book -> book instanceof Book).collect(Collectors.toList());

        assertFalse(bookList.contains(harryPotter));
    }

    @Test
    public void shouldReturnSucessWhencheckoutBook() {
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        assertTrue(library.checkoutLibraryItems(harryPotter));
    }

    @Test
    public void shouldReturnSucessWhenCheckoutMovie() {
        Movie harryPotter = new Movie(0, "Harry Potter and The Sorcerer's Stone","David Yates", 2008, "10");

        assertTrue(library.checkoutLibraryItems(harryPotter));
    }

    @Test
    public void shouldReturnWhenReturningBook() {
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        library.checkoutLibraryItems(harryPotter);
        harryPotter.setAvailable(false);

        assertTrue(library.returnLibraryItem(harryPotter));
    }

    @Test
    public void shouldReturnFalseWhenReturningNonExistingBook(){
        Book harryPotter = new Book(0, "Harry Potter and Chamber of Secrets", "J.K Rowling", 1998);

        library.returnLibraryItem(harryPotter);

        assertFalse(library.returnLibraryItem(harryPotter));
    }

    @Test
    public void shouldReturnFalseWhenReturningNonExistingMovie(){
        Movie harryPotter = new Movie(0, "Harry Potter and Chamber of Secrets", "J.K Rowling", 1998, "9");

        library.returnLibraryItem(harryPotter);

        assertFalse(library.returnLibraryItem(harryPotter));
    }

    @Test
    public void shouldReturnFalseWhenReturningSameBookTwice(){
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        library.checkoutLibraryItems(harryPotter);
        harryPotter.setAvailable(false);

        library.returnLibraryItem(harryPotter);

        assertFalse(library.returnLibraryItem(harryPotter));
    }
}
