package pl.solutions.software.sokolik.bartosz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import javax.persistence.*;

@Getter
@Setter
@RevisionEntity(CustomRevisionListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "revinfo")
public class CustomRevisionEntity {

    @Id
    @Column(name = "rev")
    @SequenceGenerator(name = "revinfo_seq_gen", sequenceName = "revinfo_id_seq", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "revinfo_seq_gen")
    @RevisionNumber
    private Long id;

    @Column(name = "revtstmp")
    @RevisionTimestamp
    private Long revisionTimestamp;

    @Column(name = "username")
    private String username;
}
