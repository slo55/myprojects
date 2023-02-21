package be.multimedi.springfilms.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String photoUrl;

    @ManyToMany(mappedBy = "actors")
    private List<Film> films = new ArrayList<>();

    public void addFilm(Film film){
        this.films.add(film);
    }
    public void removeFilm(Film film) {
        this.films.remove(film);
    }

    public int calcAge(){
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public boolean isChild(){
        return calcAge() < 18;
    }

}
