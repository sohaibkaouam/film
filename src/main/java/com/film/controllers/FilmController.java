package com.film.controllers;

import com.film.services.FilmServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {

    @Autowired
    FilmServiceImpl filmService;


}
