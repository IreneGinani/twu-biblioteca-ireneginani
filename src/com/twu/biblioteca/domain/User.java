package com.twu.biblioteca.domain;

public class User {

    private String email;
    private String libraryLogin;
    private String name;
    private String phoneNumber;
    private String role;

    public User(String email, String libraryLogin, String name, String phoneNumber, String role) {
        this.email = email;
        this.libraryLogin = libraryLogin;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    public String getLibraryLogin() { return libraryLogin; }

    public String getName() { return name; }

    public String getRole() { return role; }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name)
                .append(" - ")
                .append(email)
                .append(" - ")
                .append(phoneNumber)
                .append("\n");

        return sb.toString();
    }
}
