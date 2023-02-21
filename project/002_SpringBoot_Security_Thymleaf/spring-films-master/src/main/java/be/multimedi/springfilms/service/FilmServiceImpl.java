package be.multimedi.springfilms.service;

import be.multimedi.springfilms.model.Film;
import be.multimedi.springfilms.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmServiceImpl implements FilmService {
    private final FilmRepository filmRepo;

    @Override
    public Film registerNewFilm(Film film) {
        if (film.getId() != null) {
            throw new IllegalArgumentException("Film id must be empty (id:" + film.getId() + ")");
        }
        return filmRepo.save(film);
    }

    @Override
    public List<Film> retrieveAllFilms() {
        return filmRepo.findAll();
    }

    @Override
    public List<Film> searchFilmsByTitle(String title) {
        return filmRepo.searchByTitleContainsIgnoreCase(title);
    }

    @Override
    public Film getFilmById(Long id) {
        return filmRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void updateExistingFilm(Film film) {
        if (film.getId() == null || !filmRepo.existsById(film.getId())) {
            throw new IllegalArgumentException("Film id must exist (id:" + film.getId() + ")");
        }
        filmRepo.save(film);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Film fetchedFilm = getFilmById(id);
        fetchedFilm.getActors().forEach(a -> a.removeFilm(fetchedFilm));
        fetchedFilm.getActors().clear();
        filmRepo.deleteById(id);
    }
}
