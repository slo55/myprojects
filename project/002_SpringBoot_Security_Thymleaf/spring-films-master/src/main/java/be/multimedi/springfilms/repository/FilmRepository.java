package be.multimedi.springfilms.repository;

import be.multimedi.springfilms.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> searchByTitleContainsIgnoreCase(String title);
    List<Film> findAllByReleaseDateBetween(LocalDate start, LocalDate end);
}
