package com.ge.apm.cases.catalog.controllers;

import com.ge.apm.cases.catalog.domain.Genre;
import com.ge.apm.cases.catalog.domain.Movie;
import com.ge.apm.cases.catalog.repositories.GenreRepository;
import com.ge.apm.cases.catalog.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenreRepository genreRepository;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public Iterable<Movie> movies() {
        return movieRepository.findAll();
    }

    @RequestMapping(value = "/movies/{mlId}", method = RequestMethod.GET)
    public Movie movie(@PathVariable String mlId) {
        return movieRepository.findByMlId(mlId);
    }

    @RequestMapping(value = "/movies/genre/{genreMlId}", method = RequestMethod.GET)
    public List<Movie> moviesByGenreMlId (@PathVariable String genreMlId) {
        Genre genre = genreRepository.findByMlId(genreMlId);
        return movieRepository.findByGenre(genre);
    }
}
