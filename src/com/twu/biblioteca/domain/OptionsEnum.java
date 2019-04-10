package com.twu.biblioteca.domain;

public enum OptionsEnum {
    BookList("1"),CheckoutBook("2"),ReturnBook("3"),EXIT("0");

    public final String value;

    OptionsEnum(String value) {
        this.value = value;
    }

    public String getValor(){
        return value;
    }
}

