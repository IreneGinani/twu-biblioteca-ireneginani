package com.twu.biblioteca.parser;

import com.twu.biblioteca.domain.Movie;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieParser {

    private List<Movie> movies = new ArrayList<>();

    public MovieParser(){
        movieParser();
    }

    public List<Movie> movieParser(){
        try {

            Scanner movieFile = new Scanner(new FileReader("src/com/twu/biblioteca/data/movies.txt"));

            while (movieFile.hasNextLine()){
                String line = movieFile.nextLine();

                System.out.println(line);
                String [] movieAttributes = line.split(", ");

                Movie movie = new Movie(Integer.parseInt(movieAttributes[0]), movieAttributes[1], movieAttributes[2] ,Integer.parseInt(movieAttributes[3]), movieAttributes[4]);

                movies.add(movie);
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println("No such file or directory");
        }

        return movies;
    }

    public List<Movie> getMovieList() {
        return movies;
    }
}
