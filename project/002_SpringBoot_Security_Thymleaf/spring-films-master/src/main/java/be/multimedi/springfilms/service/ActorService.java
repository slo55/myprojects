package be.multimedi.springfilms.service;

import be.multimedi.springfilms.model.Actor;

import java.util.List;

public interface ActorService {
    Actor registerNewActor(Actor actor);
    List<Actor> retrieveAllActors();
    List<Actor> retrieveAllChildActors();

    Actor getActorById(Long id);

    List<Actor> searchActorsByName(String name);

    void updateExistingActor(Actor actor);

    void deleteById(Long id);
}
