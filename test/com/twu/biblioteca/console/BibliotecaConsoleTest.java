package com.twu.biblioteca.console;

import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Movie;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

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

        menu.getBibliotecaConsole().Login("904-8394", "irene");

        assertEquals(successMessage, menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book()));
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckingOutAMovie() {
        String successMessage = "Thank you! Enjoy the item!\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");

        assertEquals(successMessage, menu.getBibliotecaConsole().checkoutLibraryItems("0", new Movie()));
    }

    @Test
    public void shouldReturnSuccessMessageWhenReturningABook()  {
        String successMessage = "Thank you for returning the item!\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");
        menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book());

        assertEquals(successMessage, menu.getBibliotecaConsole().returnBook("2", new Book()));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenCheckingOutABook()  {
        String unsuccessfulMessage = "Sorry, that item is not available!\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");
        menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book());

        assertEquals(unsuccessfulMessage, menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book()));
    }

    @Test
    public void shouldReturnUnsuccessfulMessageWhenReturningBook()  {
        String unsuccessfulMessage = "That is not a valid item to return.\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");

        assertEquals(unsuccessfulMessage, menu.getBibliotecaConsole().returnBook("2", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToCheckoutABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");

        assertEquals(errorMessage, menu.getBibliotecaConsole().checkoutLibraryItems("10", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingIndexOutOfBoundToReturnABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");

        assertEquals(errorMessage, menu.getBibliotecaConsole().returnBook("10", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToCheckoutABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");

        assertEquals(errorMessage, menu.getBibliotecaConsole().checkoutLibraryItems("abc", new Book()));
    }

    @Test
    public void shouldReturnErrorMessageWhenUsingNonNumericIndexToReturnABook()  {
        String errorMessage = "Please, enter a valid item index!\n";

        menu.getBibliotecaConsole().Login("904-8394", "irene");

        assertEquals(errorMessage, menu.getBibliotecaConsole().returnBook("abc", new Book()));
    }

    @Test
    public void shouldReturnLibrarianMenu()  {
        String librarianMenu = "Choose an option:\n" +
                "(1) Checkouts and returns list\n" +
                "(0) Quit\n";

        assertEquals(librarianMenu, menu.getLibrarianMenu());
    }

    @Test
    public void shloudReturnLoanList(){
        String loans = "{2 - Sapiens=904-8394}";

        menu.getBibliotecaConsole().Login("904-8394", "irene");
        menu.getBibliotecaConsole().checkoutLibraryItems("0", new Book());
        menu.getBibliotecaConsole().returnBook("0", new Book());
        menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book());

        assertEquals(loans, menu.getBibliotecaConsole().getLoans());
    }

    @Test
    public void shloudReturnErrorMessageWhenCustomerUserTryAccessLoanList(){
        String errorMessage = "You are not a librarian";

        menu.getBibliotecaConsole().Login("124-4321", "pedro");
        menu.getBibliotecaConsole().checkoutLibraryItems("0", new Book());
        menu.getBibliotecaConsole().returnBook("0", new Book());
        menu.getBibliotecaConsole().checkoutLibraryItems("2", new Book());

        assertEquals(errorMessage, menu.getBibliotecaConsole().getLoans());
    }

    @Test
    public void shloudReturnErrorMessageWhenTryToCheckoutWithoutLogin(){
        String errorMessage = "You need Login!";

        menu.getBibliotecaConsole().checkoutLibraryItems("0", new Book());

        assertEquals(errorMessage, menu.getBibliotecaConsole().checkoutLibraryItems("0", new Book()));

    }

    @Test
    public void shouldReturnErrorMessageWhenTryToReturnWithoutLogin(){
        String errorMessage = "You need Login!";

        menu.getBibliotecaConsole().returnBook("0", new Book());

        assertEquals(errorMessage, menu.getBibliotecaConsole().returnBook("0", new Book()));

    }

    @Test
    public void shloudReturnSuccessWhenUserLogin(){
        assertTrue(menu.getBibliotecaConsole().Login("904-8394", "irene"));
    }

    @Test
    public void shloudReturnUnsuccessfulWhenUserLogin(){
        assertFalse(menu.getBibliotecaConsole().Login("904-8363", "irene"));
    }

    @Test
    public void shouldReturnWelcomeMessage()  {
        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(welcomeMessage, menu.getWelcomeMessage());
    }

}