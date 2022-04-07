package com.example.tbd.Repositories;

import java.util.List;
import com.example.tbd.Models.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

@Repository
public class RepositorieFilmImp implements RepositorieFilm
{
    @Autowired 
    private Sql2o sql2o;
 
    @Override
    public int countFilms()  //eliminar
    {
        int total = 0;
        String sql = "SELECT COUNT(*) FROM film";
        try(Connection conn = sql2o.open())
        {
            total = conn.createQuery(sql).executeScalar(Integer.class);
        }
        return total;
    }

    @Override
    public List<Film> getAll() {
        String sql = "SELECT * FROM film";
        try(Connection conn = sql2o.open()){
            return (List<Film>) conn.createQuery(sql).executeAndFetch(Film.class);   
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
}
