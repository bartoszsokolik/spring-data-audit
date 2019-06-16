package pl.solutions.software.sokolik.bartosz.category.domain;

import lombok.*;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import pl.solutions.software.sokolik.bartosz.domain.AuditedEntity;
import pl.solutions.software.sokolik.bartosz.movie.domain.Movie;

import javax.persistence.*;
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

    @Id
    @SequenceGenerator(name = "category_seq_gen", sequenceName = "category_id_seq", allocationSize = 1, initialValue = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
    private Long id;

    @Column(name = "name")
    private String name;

    @NotAudited
    @ManyToMany(mappedBy = "categories")
    private Set<Movie> movies = new HashSet<>();

    public Category(String name) {
        this.name = name;
    }
}
