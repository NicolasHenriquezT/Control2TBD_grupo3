package com.example.tbd.Services;

import java.util.List;
import java.util.Map;

import com.example.tbd.Repositories.RepositorieFilm;
import com.fasterxml.jackson.databind.JsonNode;
import com.example.tbd.Models.Film;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",allowedHeaders = "*")
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

    //Metodo crear
    
    @RequestMapping(value = "/newfilm", method=RequestMethod.POST)
    public Film createFilm(@RequestBody Film film) 
    {
        return repositorieFilm.createFilm(film);
    }

    //Metodo eliminar
    @DeleteMapping(value="/film/eliminar/{id}")
    public void eliminar(@PathVariable(value = "id") int id)
    {
        repositorieFilm.delete(id);
    }

    
    //Metodo eliminar
    @RequestMapping(value="/film/{id}", method = RequestMethod.GET)
    public Film getById(@PathVariable int id)
    {
        return repositorieFilm.getById(id);
    }


}








