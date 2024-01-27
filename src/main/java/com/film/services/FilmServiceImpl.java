package com.film.services;

import com.film.entities.Film;
import com.film.repositories.FilmRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    public Page<Film> getAllFilms(int pageIndex,int pageSize){
        // Appeler findAll avec une taille de page de 100
        Page<Film> result = filmRepository.findAll(PageRequest.of(pageIndex, pageSize));

        // Accéder aux résultats
        //List<Film> films = result.getContent();
        return result;
    }

    @Override
    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public List<Film> rechercheFilm(String primaryTitle, String originalTitle, String startYear) {
        return filmRepository.rechercheFilm(primaryTitle,originalTitle,startYear);
    }
}
