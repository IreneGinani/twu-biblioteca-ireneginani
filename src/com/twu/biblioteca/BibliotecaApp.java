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
            System.out.println("Choose an option:");
            System.out.println("(1) List of Books");
            System.out.println("(0) Quit");

            Scanner scan = new Scanner(System.in);
            String option = scan.next();

            if (option.equals("0")){
                break;
            }

            System.out.print(bibliotecaConsole.processOption(option));
        }
    }
}
