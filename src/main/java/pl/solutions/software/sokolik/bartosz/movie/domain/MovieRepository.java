package pl.solutions.software.sokolik.bartosz.movie.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.id = :id")
    List<Movie> findAllByActorId(@Param("id") Long id);
}
