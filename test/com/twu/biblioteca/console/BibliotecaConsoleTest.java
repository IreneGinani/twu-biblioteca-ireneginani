package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import com.twu.biblioteca.service.LibraryService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaConsoleTest{

    Menu menu;

    @Before
    public void initialization(){
        menu = new Menu();
    }

    @Test
    public void shouldNotReturnAnythingIfOptionIsQuit(){
        String output = menu.processOption("0");

        assertTrue(output.isEmpty());
    }

    @Test
    public void shouldReturnInvalidOptionMessage() {
        String invalidOptionMessage = "Please select a valid option!\n";

        assertEquals(invalidOptionMessage, menu.processOption("123"));
    }

    @Test
    public void shouldReturnListOfAllBooksWhenOptionSelectedIsOne()  {
        String expectedOutput = "Index - Title - Author - Year\n" +
                "0 - Harry Potter and The Sorcerer's Stone - J.K Rowling - 1997\n" +
                "1 - Homo Deus - Harari - 2015\n" +
                "2 - Sapiens - Harari - 2011\n";

        assertEquals(expectedOutput, menu.processOption("1"));
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckingOutABook() {
        String successMessage = "Thank you! Enjoy the item!\n";

        assertEquals(successMessage, menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book()));
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckingOutAMovie() {
        String successMessage = "Thank you! Enjoy the item!\n";

        assertEquals(successMessage, menu.getBibliotecaConsole().checkoutLibraryItems("0", new Movie()));
    }

    @Test
    public void shouldReturnSuccessMessageWhenReturningABook()  {
        String successMessage = "Thank you for returning the item!\n";

        menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book());

        assertEquals(successMessage, menu.getBibliotecaConsole().returnBook("2", new Book()));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenCheckingOutABook()  {
        menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book());

        String unsuccessfulMessage = "Sorry, that item is not available!\n";

        assertEquals(unsuccessfulMessage, menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book()));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenReturningBook()  {
        String unsuccessfulMessage = "That is not a valid item to return.\n";

        assertEquals(unsuccessfulMessage, menu.getBibliotecaConsole().returnBook("2", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToCheckoutABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        assertEquals(errorMessage, menu.getBibliotecaConsole().checkoutLibraryItems("10", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToReturnABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        assertEquals(errorMessage, menu.getBibliotecaConsole().returnBook("10", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToCheckoutABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        assertEquals(errorMessage, menu.getBibliotecaConsole().checkoutLibraryItems("abc", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToReturnABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        assertEquals(errorMessage, menu.getBibliotecaConsole().returnBook("abc", new Book()));
    }

    @Test
    public void shouldReturnWelcomeMessage()  {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(welcomeMessage, menu.getWelcomeMessage());
    }
}