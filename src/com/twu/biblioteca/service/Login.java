package com.twu.biblioteca.service;

import com.twu.biblioteca.parser.UserCredentialsParser;

import java.util.HashMap;

public class Login {
    private HashMap<String, String> usersData;
    private UserCredentialsParser userCredentialsParser = new UserCredentialsParser();

    public Login() {
        this.usersData = userCredentialsParser.getCredentialsList();
    }

    public boolean Authenticate(String username, String password){

        if (usersData.containsKey(username) && usersData.get(username).equals(password)){
            return true;
        }

        return false;
    }
}
