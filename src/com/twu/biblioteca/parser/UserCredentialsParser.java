package com.twu.biblioteca.parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class UserCredentialsParser {
    private HashMap<String, String> userCredentials = new HashMap<>();

    public UserCredentialsParser(){
        userCredentialsParser();
    }

    public HashMap<String, String> userCredentialsParser(){
        try {

            Scanner userCredentialsFile = new Scanner(new FileReader("src/com/twu/biblioteca/data/userCredentials.txt"));

            while (userCredentialsFile.hasNextLine()) {
                String line = userCredentialsFile.nextLine();

                String[] userCredentialsAttributes = line.split(", ");

                userCredentials.put(userCredentialsAttributes[0], userCredentialsAttributes[1]);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No such file or directory");
        }

        return userCredentials;
    }

    public HashMap<String, String> getCredentialsList() {
        return userCredentials;
    }
}
