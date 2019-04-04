package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaConsole {

    public List<String> getBookList() {
        return Arrays.asList("Harry Potter and The Sorcerer's Stone",  "Homo Deus", "Sapiens");
    }

    public String getWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }
}
