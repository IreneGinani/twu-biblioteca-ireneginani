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
    public void shouldReturnSuccessMessageWhenCheckingOutAMovie() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String expectedOutput = "Index - Name - Year - Director - Rating\n" +
                "0 - Harry Potter and The Sorcerer's Stone - 2008 - David Yates - 10\n";

        assertEquals(expectedOutput, bibliotecaConsole.processOption("5"));
    }

    @Test
    public void shouldReturnSuccessMessageWhenReturningABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String successMessage = "Thank you for returning the book!\n";

        bibliotecaConsole.checkoutBook("2");

        assertEquals(successMessage, bibliotecaConsole.returnBook("2"));
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
    public void shouldReturnUnsuccessfulMessageWhenReturningBook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String unsuccessfulMessage = "That is not a valid book to return.\n";

        assertEquals(unsuccessfulMessage, bibliotecaConsole.returnBook("2"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToCheckoutABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.checkoutBook("10"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToCheckoutAMovie() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.processOption("5"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToReturnABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.returnBook("10"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToCheckoutABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.checkoutBook("abc"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToReturnABook() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.returnBook("abc"));
    }

    @Test
    public void shouldReturnWelcomeMessage() {
        Library library = new Library();
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(welcomeMessage, bibliotecaConsole.getWelcomeMessage());
    }
}