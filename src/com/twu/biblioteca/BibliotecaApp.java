package com.twu.biblioteca;

import com.twu.biblioteca.console.Menu;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Menu menu = new Menu();

        System.out.println(menu.getWelcomeMessage());

        if (menu.Login()) {
            while (true) {
                System.out.println(menu.getMainMenu());

                Scanner scan = new Scanner(System.in);
                String option = scan.next();

                String output = menu.processOption(option);
                if (output.isEmpty()) {
                    break;
                }

                System.out.print(output);
            }
        } else {
            System.out.print("Sorry, username or password wrong\n");
        }
    }
}
