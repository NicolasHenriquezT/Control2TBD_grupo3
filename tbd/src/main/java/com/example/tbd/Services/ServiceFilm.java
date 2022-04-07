package com.example.tbd.Services;

import java.util.List; 

import com.example.tbd.Repositories.RepositorieFilm;
import com.example.tbd.Models.Film;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFilm {

    private final RepositorieFilm repositorieFilm;

    ServiceFilm(RepositorieFilm repositorieFilm){
        this.repositorieFilm = repositorieFilm;
    }

    @GetMapping("/films/total")  //eliminar
    public String countFilms()
    {
        int total = repositorieFilm.countFilms();
        return String.format("Hay un total de %s",total);
    }
    
    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public List<Film> getAllFilm(){
        return repositorieFilm.getAll();
    }

    



}








