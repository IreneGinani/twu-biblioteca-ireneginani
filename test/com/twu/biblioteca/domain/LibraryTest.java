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

        library.checkoutBook(harryPotter);

        assertFalse(library.checkoutBook(harryPotter));
    }

    @Test
    public void shouldReturnFalseWhenCheckoutNonExistingBook() {
        Book harryPotter = new Book(0, "Harry Potter and Chamber of Secrets", "J.K Rowling", 1998);

        library.checkoutBook(harryPotter);

        assertFalse(library.checkoutBook(harryPotter));
    }

    @Test
    public void shouldReturnListOfAllBooks() {
        List<String> expectedBookTitleList =
                Arrays.asList("Harry Potter and The Sorcerer's Stone",  "Homo Deus", "Sapiens");

        List<String> actualBookTitleList =
                library.getLibrary().getBookList().stream().map(Book::getTitle).collect(Collectors.toList());

        assertEquals(expectedBookTitleList, actualBookTitleList);
    }

    @Test
    public void shouldReturnListOfAllBooksWithTitleAuthorAndPublication(){
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book(1 , "Homo Deus", "Harari", 2015);
        Book sapiens = new Book(2, "Sapiens", "Harari", 2011);

        List<Book> bookList = Arrays.asList(harryPotter, homoDeus, sapiens);

        assertEquals(bookList, library.getLibrary().getBookList());
    }

    @Test
    public void shouldReturnTheListOfAvailableBooks(){
       Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        library.checkoutBook(harryPotter);

        List<Book> bookList = library.getLibrary().getAvailableBookList();

        assertFalse(bookList.contains(harryPotter));
    }

    @Test
    public void shouldReturnTrueWhenCheckoutBook() {
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        assertTrue(library.checkoutBook(harryPotter));
    }

    @Test
    public void shouldReturnTrueWhenReturningBook() {
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        library.checkoutBook(harryPotter);
        harryPotter.setAvailable(false);

        assertTrue(library.returnBook(harryPotter));
    }

    @Test
    public void shouldReturnFalseWhenReturningNonExistingBook(){
        Book harryPotter = new Book(0, "Harry Potter and Chamber of Secrets", "J.K Rowling", 1998);

        library.returnBook(harryPotter);

        assertFalse(library.returnBook(harryPotter));
    }

    @Test
    public void shouldReturnFalseWhenReturningSameBookTwice(){
        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);

        library.checkoutBook(harryPotter);
        harryPotter.setAvailable(false);

        library.returnBook(harryPotter);

        assertFalse(library.returnBook(harryPotter));
    }
}
