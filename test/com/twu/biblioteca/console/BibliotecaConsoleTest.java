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
    public void shouldReturnInvalidOptionMessage() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String invalidOptionMessage = "Please select a valid option!";

        assertEquals(invalidOptionMessage, bibliotecaConsole.processOption(123));
    }

    @Test
    public void shouldReturnListOfAllBooksWhenOptionSelectedIsOne() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);
        String expectedOutput = "Title - Author - Year\n" +
                                "Harry Potter and The Sorcerer's Stone - J.K Rowling - 1997\n" +
                                "Homo Deus - Harari - 2015\n" +
                                "Sapiens - Harari - 2011\n";

        int option = 1;

        assertEquals(expectedOutput, bibliotecaConsole.processOption(option));
    }
}