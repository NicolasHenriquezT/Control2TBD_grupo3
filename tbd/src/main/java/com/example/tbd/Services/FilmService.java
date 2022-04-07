package com.example.tbd.Services;

import com.example.tbd.Repositories.FilmRepositories;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmService
{

    private final FilmRepositories filmRepositories;
    FilmService(FilmRepositories filmRepositories)
    {
        this.filmRepositories = filmRepositories;
    }

    @GetMapping("/films/total")
    public String countFilms()
    {
        int total = filmRepositories.countFilms();
        return String.format("Hay un total de %s",total);
    }
}
