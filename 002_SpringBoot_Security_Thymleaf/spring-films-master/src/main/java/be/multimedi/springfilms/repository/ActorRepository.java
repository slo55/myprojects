package be.multimedi.springfilms.repository;

import be.multimedi.springfilms.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> searchByNameContainsIgnoreCase(String name);
}
