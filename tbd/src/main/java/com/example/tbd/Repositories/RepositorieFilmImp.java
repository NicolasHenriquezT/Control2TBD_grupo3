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
    public List<Film> getAll() {
        String sql = "SELECT * FROM film";
        try(Connection conn = sql2o.open()){
            return (List<Film>) conn.createQuery(sql).executeAndFetch(Film.class);   
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }

    //Metodo update
    @Override
    public void update(Film f) {
        String sql = "UPDATE film SET titulo="+"'"+f.getTitulo()+"'"+", categoria="+"'"+f.getCategoria()+"'"+" WHERE id = "+f.getId();
        System.out.println(sql);
        try(Connection conn = sql2o.open())
        {
            conn.createQuery(sql).executeUpdate();
        }catch(Exception e)
        {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" error al actualizar\n");
        }
    }

    @Override
    public boolean delete(Film film) {
        // TODO Auto-generated method stub
        return false;
    }
}
