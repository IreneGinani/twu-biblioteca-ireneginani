package com.twu.biblioteca.domain;

public class User {

    private String libraryLogin;
    private String name;
    private String role;

    public User(String libraryLogin, String name, String role) {
        this.libraryLogin = libraryLogin;
        this.name = name;
        this.role = role;
    }

    public String getLibraryLogin() { return libraryLogin; }

    public String getName() { return name; }

    public String getRole() { return role; }
}
