package com.twu.biblioteca.console;

import com.twu.biblioteca.Service.LibraryService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaConsoleTest {

    LibraryService library;
    BibliotecaConsole bibliotecaConsole;

    @Before
    public void initialization(){
        library = new LibraryService();
        bibliotecaConsole = new BibliotecaConsole(library);
    }

    @Test
    public void shouldNotReturnAnythingIfOptionIsQuit(){
        String output = bibliotecaConsole.processOption("0");

        assertTrue(output.isEmpty());
    }

    @Test
    public void shouldReturnInvalidOptionMessage() {
        String invalidOptionMessage = "Please select a valid option!\n";

        assertEquals(invalidOptionMessage, bibliotecaConsole.processOption("123"));
    }

    @Test
    public void shouldReturnListOfAllBooksWhenOptionSelectedIsOne()  {
        String expectedOutput = "Index - Title - Author - Year\n" +
                "0 - Harry Potter and The Sorcerer's Stone - J.K Rowling - 1997\n" +
                "1 - Homo Deus - Harari - 2015\n" +
                "2 - Sapiens - Harari - 2011\n";

        assertEquals(expectedOutput, bibliotecaConsole.processOption("1"));
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckingOutABook() {
        String successMessage = "Thank you! Enjoy the book!\n";

        assertEquals(successMessage, bibliotecaConsole.checkoutBook("2"));
    }

    @Test
    public void shouldReturnSuccessMessageWhenReturningABook()  {
        String successMessage = "Thank you for returning the book!\n";

        bibliotecaConsole.checkoutBook("2");

        assertEquals(successMessage, bibliotecaConsole.returnBook("2"));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenCheckingOutABook()  {
        bibliotecaConsole.checkoutBook("2");

        String unsuccessfulMessage = "Sorry, that book is not available!\n";

        assertEquals(unsuccessfulMessage, bibliotecaConsole.checkoutBook("2"));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenReturningBook()  {
        String unsuccessfulMessage = "That is not a valid book to return.\n";

        assertEquals(unsuccessfulMessage, bibliotecaConsole.returnBook("2"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToCheckoutABook()  {
        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.checkoutBook("10"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToReturnABook()  {
        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.returnBook("10"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToCheckoutABook()  {
        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.checkoutBook("abc"));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToReturnABook()  {
        String errorMessage = "Please, enter a valid book index!\n";

        assertEquals(errorMessage, bibliotecaConsole.returnBook("abc"));
    }

    @Test
    public void shouldReturnWelcomeMessage()  {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(welcomeMessage, bibliotecaConsole.getWelcomeMessage());
    }
}