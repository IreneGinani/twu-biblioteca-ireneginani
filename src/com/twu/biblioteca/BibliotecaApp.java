package com.twu.biblioteca;

import com.twu.biblioteca.console.BibliotecaConsole;
import com.twu.biblioteca.domain.Book;
import com.twu.biblioteca.domain.Library;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();

        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        System.out.println(bibliotecaConsole.getWelcomeMessage());

        System.out.println("Choose an option:");
        System.out.println("(1) List of Books");

        Scanner scan = new Scanner(System.in);

        int option = scan.nextInt();

        bibliotecaConsole.processOption(option);


    }
}
