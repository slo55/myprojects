package be.multimedi.springfilms.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private LocalDate releaseDate;
//    @NotNull    // Cannot be null
//    @NotEmpty   // Cannot be null, cannot be empty quotes ""
    @NotBlank   // Cannot be null, cannot be empty quotes "", cannot be just whitespaces "   "
    private String posterUrl;
    @ManyToMany
    @JoinTable(name = "film_actor",
    joinColumns = @JoinColumn(name = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors = new ArrayList<>();

    public void addActor(Actor actor){
        this.actors.add(actor);
    }
    public void removeActor(Actor actor) {
        this.actors.remove(actor);
    }

    public String getFullTitle(){
        return String.format("%s (%d)", title, releaseDate.getYear());
    }

}
