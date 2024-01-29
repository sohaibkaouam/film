package com.film.controllers;

import com.film.entities.Film;
import com.film.services.FilmServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {

    private final FilmServiceImpl filmService;

    @GetMapping("/listFilms")
    public List<Film> getAllFilms(@RequestParam("pageIndex") int pageIndex,
        @RequestParam("pageSize") int pageSize) {
        return filmService.getAllFilms(pageIndex,pageSize).getContent();
    }

    @PostMapping("/addNewFilm")
    public ResponseEntity<Film> addEmployee(@RequestBody Film film) {
        try {
            return new ResponseEntity<>(filmService.addFilm(film), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

        @GetMapping("/search")
    public List<Film> searchMovies(
        @RequestParam(required = false) String primaryTitle,
        @RequestParam(required = false) String originalTitle,
        @RequestParam(required = false) String startYear) {
        // Implémentez la logique de recherche basée sur les critères
        // Utilisez le service pour récupérer les résultats
        return filmService.rechercheFilm(primaryTitle, originalTitle, startYear);
    }






}
