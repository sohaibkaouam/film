package com.film.services;

import com.film.entities.Film;
import com.film.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final FilmRepository filmRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            Resource resource = new ClassPathResource("title.basics.tsv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                // Créer une instance de VotreEntite et définir les valeurs
                Film film = new Film();
                film.setTconst(parts[0]);
                film.setTitleType(parts[1]);
                film.setPrimaryTitle(parts[2]);
                film.setOriginalTitle(parts[3]);
                film.setIsAdult(parts[4]);
                film.setStartYear(parts[5]);
                film.setEndYear(parts[6]);
                film.setRuntimeMinutes(parts[7]);
                film.setGenres(parts[8]);

                // ... définir d'autres propriétés
                // Enregistrer l'entité dans la base de données
                filmRepository.save(film);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
