package com.film.services;

import com.film.entities.Film;
import java.util.List;
import org.springframework.stereotype.Service;


public interface FilmService {

    public Film addFilm(Film film);

    public List<Film> rechercheFilm(String primaryTitle, String originalTitle, String startYear);

}
