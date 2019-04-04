package com.twu.biblioteca.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void shouldReturnListOfAllBooks() {
        Library library = new Library();

        List<String> expectedBookTitleList =
                Arrays.asList("Harry Potter and The Sorcerer's Stone",  "Homo Deus", "Sapiens");

        List<String> actualBookTitleList =
                library.getBookList().stream().map(Book::getTitle).collect(Collectors.toList());

        assertEquals(expectedBookTitleList, actualBookTitleList);
    }

    @Test
    public void shouldReturnListOfAllBooksWithTitleAuthorAndPublication() {
        Library library = new Library();

        Book harryPotter = new Book("Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);
        Book homoDeus = new Book("Homo Deus", "Harari", 2015);
        Book sapiens = new Book("Sapiens", "Harari", 2011);

        List<Book> bookList = Arrays.asList(harryPotter, homoDeus, sapiens);

        assertEquals(bookList, library.getBookList());
    }
}