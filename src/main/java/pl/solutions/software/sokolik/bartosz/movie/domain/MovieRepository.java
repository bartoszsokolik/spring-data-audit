package pl.solutions.software.sokolik.bartosz.movie.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.id = :id")
    List<Movie> findAllByActorId(@Param("id") Long id);

    Optional<Movie> findByTitle(String title);
}
