package com.film.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tconst;
    private String titleType;

    @Column(length = 500)
    private String primaryTitle;

    @Column(length = 500)
    private String originalTitle;

    private String isAdult;

    private String startYear;

    private String endYear;

    private String runtimeMinutes;

    private String genres;


}
