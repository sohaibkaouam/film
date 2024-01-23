package com.film.repositories;

import com.film.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film,String> {

}
