package com.twu.biblioteca.parser;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BookParserTest {

    @Test
    public void shouldReturnFalseWhenCheckoutSameBookTwice() throws FileNotFoundException {
        BookParser parser = new BookParser();

        Book harryPotter = new Book(0, "Harry Potter and The Sorcerer's Stone", "J.K Rowling", 1997);
        Book homoDeus = new Book(1 , "Homo Deus", "Harari", 2015);
        Book sapiens = new Book(2, "Sapiens", "Harari", 2011);

        List<Book> books = new ArrayList<>(Arrays.asList(harryPotter, homoDeus, sapiens));

        assertEquals(books, parser.getBookList());
    }
}
