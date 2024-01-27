package com.film.repositories;

import com.film.entities.Film;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {

    Page<Film> findAll(Pageable pageable);

    @Query("SELECT f FROM Film f WHERE " +
        "(:primaryTitle is null or f.primaryTitle like %:primaryTitle%) and " +
        "(:originalTitle is null or f.originalTitle like %:originalTitle%) and " +
        "(:startYear is null or f.startYear like %:startYear%)")
    List<Film> rechercheFilm(
        @Param("primaryTitle") String primaryTitle,
        @Param("originalTitle") String originalTitle,
        @Param("startYear") String startYear
    );
}
