package pl.solutions.software.sokolik.bartosz.actor.domain;

import lombok.*;
import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import pl.solutions.software.sokolik.bartosz.domain.AuditedEntity;
import pl.solutions.software.sokolik.bartosz.movie.domain.Movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@Audited
@AuditTable("actors_aud")
public class Actor extends AuditedEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @AuditJoinTable(name = "movies_actors_aud")
    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();

    @Builder
    public Actor(Long id, String createdBy, LocalDateTime createdDate, String lastModifiedBy, LocalDateTime lastModifiedDate, String firstName, String lastName) {
        super(id, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
