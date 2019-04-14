package com.twu.biblioteca.parser;

import com.twu.biblioteca.domain.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserParser {
    
    private List<User> users = new ArrayList<>();

    public UserParser(){
        UserParser();
    }

    public List<User> UserParser(){
        try {

            Scanner userFile = new Scanner(new FileReader("src/com/twu/biblioteca/data/users.txt"));

            while (userFile.hasNextLine()){
                String line = userFile.nextLine();

                String [] userAttributes = line.split(", ");

                User user = new User(userAttributes[0], userAttributes[1], userAttributes[2], userAttributes[3], userAttributes[4]);

                users.add(user);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No such file or directory");
        }

        return users;
    }

    public List<User> getUserList() {
        return users;
    }
}
