package pl.solutions.software.sokolik.bartosz.category.domain;

import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import pl.solutions.software.sokolik.bartosz.domain.AuditedEntity;
import pl.solutions.software.sokolik.bartosz.movie.domain.Movie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Audited
@Entity
@Table(name = "categories")
@AuditTable(value = "categories_aud")
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Category extends AuditedEntity {

    @Column(name = "name")
    private String name;

    @NotAudited
    @ManyToMany(mappedBy = "categories")
    private Set<Movie> movies = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}
