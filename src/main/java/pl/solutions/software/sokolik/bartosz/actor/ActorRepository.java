package pl.solutions.software.sokolik.bartosz.actor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a JOIN FETCH a.movies m WHERE a.id = :id")
    List<Actor> findActorsWithMovies(@Param("id") Long id);
}
