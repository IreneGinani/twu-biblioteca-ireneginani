package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Library;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaConsoleTest {

    @Test
    public void shouldNotReturnAnythingIfOptionIsQuit() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String output = bibliotecaConsole.processOption("0");

        assertTrue(output.isEmpty());
    }

    @Test
    public void shouldReturnInvalidOptionMessage() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String invalidOptionMessage = "Please select a valid option!\n";

        assertEquals(invalidOptionMessage, bibliotecaConsole.processOption("123"));
    }

    @Test
    public void shouldReturnListOfAllBooksWhenOptionSelectedIsOne() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String expectedOutput = "Index - Title - Author - Year\n" +
                "0 - Harry Potter and The Sorcerer's Stone - J.K Rowling - 1997\n" +
                "1 - Homo Deus - Harari - 2015\n" +
                "2 - Sapiens - Harari - 2011\n";

        assertEquals(expectedOutput, bibliotecaConsole.processOption("1"));
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckingOutABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String successMessage = "Thank you! Enjoy the book!\n";

        assertEquals(successMessage, bibliotecaConsole.checkoutBook("2"));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenCheckingOutABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        bibliotecaConsole.checkoutBook("2");

        String unsuccessfulMessage = "Sorry, that book is not available!\n";

        assertEquals(unsuccessfulMessage, bibliotecaConsole.checkoutBook("2"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToCheckoutABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.checkoutBook("abc"));
    }

    @Test
    public void shouldReturnWelcomeMessage() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(welcomeMessage, bibliotecaConsole.getWelcomeMessage());
    }
}