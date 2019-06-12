package pl.solutions.software.sokolik.bartosz.actor.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a JOIN FETCH a.movies")
    List<Actor> findActorsWithMovies();
}
