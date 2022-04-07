package com.example.tbd.Repositories;

import java.util.List;
import com.example.tbd.Models.Film;

public interface RepositorieFilm
{
    public int countFilms(); //eliminar
    public List<Film> getAll(); 
    public Film createFilm(Film film);
}

