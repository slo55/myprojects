package be.multimedi.springfilms.service;

import be.multimedi.springfilms.model.Actor;
import be.multimedi.springfilms.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepo;

    @Override
    public Actor registerNewActor(Actor actor) {
        if (actor.getId() != null){
            throw new IllegalArgumentException();
        }
        return actorRepo.save(actor);
    }

    @Override
    public List<Actor> retrieveAllActors() {
        return actorRepo.findAll();
    }

    @Override
    public List<Actor> retrieveAllChildActors() {
        return retrieveAllActors().stream()
                .filter(Actor::isChild)
                .collect(Collectors.toList());
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Actor> searchActorsByName(String name) {
        return actorRepo.searchByNameContainsIgnoreCase(name);
    }

    @Override
    public void updateExistingActor(Actor actor) {
        if (actor.getId() == null || !actorRepo.existsById(actor.getId())){
            throw new IllegalArgumentException();
        }
        actorRepo.save(actor);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Actor fetchedActor = getActorById(id);
        // Removing many-to-many relationships
        fetchedActor.getFilms().forEach(f -> {
            f.removeActor(fetchedActor);
        });
        fetchedActor.getFilms().clear();
        // Deleting actor
        actorRepo.deleteById(id);
    }
}
