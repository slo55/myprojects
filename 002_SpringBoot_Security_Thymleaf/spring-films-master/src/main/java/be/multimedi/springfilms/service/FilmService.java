package be.multimedi.springfilms.service;

import be.multimedi.springfilms.model.Film;

import java.util.List;

public interface FilmService {
    Film registerNewFilm(Film film);
    List<Film> retrieveAllFilms();
    List<Film> searchFilmsByTitle(String title);
    Film getFilmById(Long id);

    void updateExistingFilm(Film film);

    void deleteById(Long id);
}
