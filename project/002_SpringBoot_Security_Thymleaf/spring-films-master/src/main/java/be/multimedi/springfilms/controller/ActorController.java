package be.multimedi.springfilms.controller;


import be.multimedi.springfilms.model.Actor;
import be.multimedi.springfilms.model.Film;
import be.multimedi.springfilms.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller // @Controller = @Component + autoconfiguratie van Spring + semantische betekenis
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @GetMapping("/actors")
    public String fetchActorsPage(Model model){
        List<Actor> allActors = actorService.retrieveAllActors();
        model.addAttribute("actors", allActors);
        return "actor-list";
    }

    @GetMapping(value = "/actors", params = "searchText")
    public String searchActors(@RequestParam String searchText, Model model){
        List<Actor> searchedActors = actorService.searchActorsByName(searchText);
        model.addAttribute("actors", searchedActors);
        return "actor-list";
    }

    @GetMapping("/actor/{id}")
    public String fetchActorDetail(@PathVariable Long id, Model model){
        Actor actor = actorService.getActorById(id);
        model.addAttribute("actor", actor);
        return "actor-detail";
    }

    @GetMapping("/actor/new")
    public String fetchNewActorForm(Model model){
        model.addAttribute("actor", new Actor());
        return "actor-form";
    }

    @PostMapping("/actor/new")
    public String addNewActor(Actor actor){
        actor = actorService.registerNewActor(actor);
        return "redirect:/actor/" + actor.getId();
    }

    @GetMapping("/actor/{id}/edit")
    public String fetchUpdateActorForm(@PathVariable Long id, Model model){
        Actor fetchedActor = actorService.getActorById(id);
        model.addAttribute("actor", fetchedActor);
        return "actor-form";
    }

    @PostMapping("/actor/{id}/edit")
    public String updateExistingActor(Actor actor){
        actorService.updateExistingActor(actor);
        return "redirect:/actor/" + actor.getId();
    }

    @GetMapping("/actor/{id}/delete")
    public String deleteActor(@PathVariable Long id){
        actorService.deleteById(id);
        return "redirect:/actors";
    }
}
