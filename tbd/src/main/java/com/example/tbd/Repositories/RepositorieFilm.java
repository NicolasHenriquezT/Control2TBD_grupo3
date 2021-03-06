package com.example.tbd.Repositories;

import java.util.List;
import com.example.tbd.Models.Film;

public interface RepositorieFilm
{
    public List<Film> getAll(); //Read
    public void update(Film film);
    public void delete(int id);
    public Film createFilm(Film film);
    public Film getById(int id);
}

