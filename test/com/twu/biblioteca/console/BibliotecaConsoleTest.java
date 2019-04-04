package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaConsoleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(welcomeMessage, bibliotecaConsole.getWelcomeMessage());
    }

    @Test
    public void shouldReturnListOfAllBooksWhenOptionSelectedIsOne() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        Book harryPotter = new Book("Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);
        Book homoDeus = new Book("Homo Deus", "Harari", 2015);
        Book sapiens = new Book("Sapiens", "Harari", 2011);

        List<Book> bookList = Arrays.asList(harryPotter, homoDeus, sapiens);
        int option = 1;

        assertEquals(bookList, bibliotecaConsole.processOption(option));
    }
}