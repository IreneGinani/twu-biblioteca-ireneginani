package com.twu.biblioteca;

import com.twu.biblioteca.console.BibliotecaConsole;
import com.twu.biblioteca.domain.Library;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();

        BibliotecaConsole bibliotecaConsole = new BibliotecaConsole(library);

        System.out.println(bibliotecaConsole.getWelcomeMessage());

        while (true){
            System.out.println(bibliotecaConsole.getMainMenu());

            Scanner scan = new Scanner(System.in);
            String option = scan.next();

            String output = bibliotecaConsole.processOption(option);

            if (output == null) {
                break;
            }

            System.out.print(output);
        }
    }
}
