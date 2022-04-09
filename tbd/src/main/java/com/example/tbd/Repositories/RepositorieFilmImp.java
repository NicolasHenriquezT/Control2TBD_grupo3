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

    @Override
    public Film createFilm(Film film) {
        String sql = "INSERT INTO film (titulo, categoria, duracion) VALUES(:titulo, :categoria, :duracion)";
    
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql,true)
            .addParameter("titulo", film.getTitulo())
            .addParameter("categoria", film.getCategoria())
            .addParameter("duracion", film.getDuracion())
            .executeUpdate().getKey();

            film.setId(id);
            return film;
        
        }
        catch (Exception e) {
            System.out.println(e.getCause() + e.getLocalizedMessage() + "\n");
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
    public void delete(int id) {
        String sql = "DELETE FROM film WHERE id="+id;
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
    public Film getById(int id) {
        String sql = "SELECT * FROM film WHERE id="+ Integer.toString(id);

        try(Connection conn = sql2o.open()){
            List<Film> l = conn.createQuery(sql).executeAndFetch(Film.class);   
            return l.get(0);
            
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getLocalizedMessage()+" no conecté \n");
        }
        return null;
    }
}
