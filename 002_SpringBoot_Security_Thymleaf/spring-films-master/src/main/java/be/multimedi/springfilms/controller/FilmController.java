package be.multimedi.springfilms.controller;

import be.multimedi.springfilms.model.Actor;
import be.multimedi.springfilms.model.Film;
import be.multimedi.springfilms.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller // @Controller = @Component + autoconfiguratie van Spring + semantische betekenis
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @GetMapping("/films")
    public String fetchFilmsPage(Model model){
        List<Film> allFilms = filmService.retrieveAllFilms();
        model.addAttribute("films", allFilms);
        return "film-list";
    }

    @GetMapping(value = "/films", params = "searchText")
    public String searchFilms(@RequestParam String searchText, Model model){
        List<Film> searchedFilms = filmService.searchFilmsByTitle(searchText);
        model.addAttribute("films", searchedFilms);
        return "film-list";
    }

    @GetMapping("/film/{id}")
    public String fetchFilmDetail(@PathVariable Long id, Model model){
        Film film = filmService.getFilmById(id);
        model.addAttribute("film", film);
        return "film-detail";
    }

    @GetMapping("/film/new")
    public String fetchNewFilmForm(Model model){
        model.addAttribute("film", new Film()); // TODO: Use DTO
        return "film-form";
    }

    @PostMapping("/film/new")
    public String addNewFilm(@Valid Film film, BindingResult br){ // TODO: Use DTO
        if (br.hasErrors()){
            return "film-form";
        }
        filmService.registerNewFilm(film);
        return "redirect:/films";
    }

    @GetMapping("/film/{id}/edit")
    public String fetchUpdateFilmForm(@PathVariable Long id, Model model){
        Film fetchedFilm = filmService.getFilmById(id);
        model.addAttribute("film", fetchedFilm);
        return "film-form";
    }

    @PostMapping("/film/{id}/edit")
    public String updateExistingFilm(Film film){
        filmService.updateExistingFilm(film);
        return "redirect:/film/" + film.getId();
    }

    @GetMapping("/film/{id}/delete")
    public String deleteFilm(@PathVariable Long id){
        filmService.deleteById(id);
        return "redirect:/films";
    }
}
