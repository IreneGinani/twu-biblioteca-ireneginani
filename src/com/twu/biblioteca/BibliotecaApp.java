package com.twu.biblioteca;

import com.twu.biblioteca.console.Menu;
import com.twu.biblioteca.service.LibraryService;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();

        System.out.println(menu.getWelcomeMessage());

        while (true){
            System.out.println(menu.getMainMenu());

            Scanner scan = new Scanner(System.in);
            String option = scan.next();

            String output = menu.processOption(option);

            if (output.isEmpty()) {
                break;
            }

            System.out.print(output);
        }


    }
}
