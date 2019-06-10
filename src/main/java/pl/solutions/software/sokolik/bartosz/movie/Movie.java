package pl.solutions.software.sokolik.bartosz.movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import pl.solutions.software.sokolik.bartosz.actor.Actor;
import pl.solutions.software.sokolik.bartosz.domain.AuditedEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Audited
@AuditTable(value = "movies_aud")
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie extends AuditedEntity {

    @Column(name = "title")
    private String title;

    @ManyToMany
    @AuditJoinTable(name = "movies_actors_aud")
    @JoinTable(name = "movies_actors", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    private Set<Actor> actors = new HashSet<>();

    @Builder
    public Movie(Long id,String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, String title) {
        super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.title = title;
    }

    public Movie(String title) {
        this.title = title;
    }
}
