package com.twu.biblioteca.parser;

import com.twu.biblioteca.domain.Book;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BookParser {

    private List<Book> books = new ArrayList<>();

    public BookParser() throws FileNotFoundException {
        Scanner bookFile = new Scanner(new FileReader("src/com/twu/biblioteca/data/books.txt"));

        while (bookFile.hasNextLine()){
            String line = bookFile.nextLine();

            System.out.println(line);
            String [] bookAttributes = line.split(", ");

            Book book = new Book(Integer.parseInt(bookAttributes[0]), bookAttributes[1], bookAttributes[2] ,Integer.parseInt(bookAttributes[3]));

            books.add(book);
        }

    }

    public List<Book> getBookList() {
        return books;
    }
}


