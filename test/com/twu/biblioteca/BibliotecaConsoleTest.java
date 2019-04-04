package com.twu.biblioteca;

import com.twu.biblioteca.domain.Book;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BibliotecaConsoleTest {

    @Test
    public void shouldReturnWelcomeMessage() {
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole();

        String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";

        assertEquals(welcomeMessage, bibliotecaConsole.getWelcomeMessage());
    }

    @Test
    public void shouldReturnListOfAllBooks() {
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole();

        List<String> bookList = Arrays.asList("Harry Potter and The Sorcerer's Stone",  "Homo Deus", "Sapiens");

        assertEquals(bookList, bibliotecaConsole.getBookList());
    }

    @Test
    public void shouldReturnListOfAllBooksWithTitleAuthorAndPublication() {
        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole();

        Book harryPotter = new Book("Harry Potter and The Sorcerer's Stone","J.K Rowling", 1997);
        Book homoDeus = new Book("Homo Deus", "Harari", 2015);
        Book sapiens = new Book("Sapiens", "Harari", 2011);

        List<Book> bookList = Arrays.asList(harryPotter, homoDeus, sapiens);

        assertEquals(bookList, bibliotecaConsole.getBookList());
    }
}