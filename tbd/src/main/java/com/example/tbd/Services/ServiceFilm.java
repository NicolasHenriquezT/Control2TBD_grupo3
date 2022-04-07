package com.example.tbd.Services;

import java.util.List; 

import com.example.tbd.Repositories.RepositorieFilm;
import com.example.tbd.Models.Film;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceFilm {

    private final RepositorieFilm repositorieFilm;

    ServiceFilm(RepositorieFilm repositorieFilm){
        this.repositorieFilm = repositorieFilm;
    }
    
    //Metodo leer
    @RequestMapping(value = "/film", method = RequestMethod.GET)
    public List<Film> getAllFilm(){
        return repositorieFilm.getAll();
    }

    //Metodo actualizar
    @RequestMapping(value="/film/actualizar",method=RequestMethod.PUT)
    public void actualizarFilms(@RequestBody Film film)
    {
        repositorieFilm.update(film);
    }

    @PostMapping("/newFilm")
    @ResponseBody
    public Film createFilm(@RequestBody Film film) {
        return repositorieFilm.createFilm(film);
    }

    



}








