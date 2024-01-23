package com.film.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tconst;

    private String titleType;

    private String primaryTitle;

    private String originalTitle;

    private String isAdult;

    private String startYear;

    private String endYear;

    private String runtimeMinutes;

    private String genres;


}
