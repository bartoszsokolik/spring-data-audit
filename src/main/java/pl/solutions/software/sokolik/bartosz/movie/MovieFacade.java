package pl.solutions.software.sokolik.bartosz.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solutions.software.sokolik.bartosz.actor.ActorFacade;
import pl.solutions.software.sokolik.bartosz.movie.dto.AssignMovieRequest;
import pl.solutions.software.sokolik.bartosz.movie.dto.MovieDto;
import pl.solutions.software.sokolik.bartosz.movie.dto.MovieNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieFacade {

    private final MovieRepository movieRepository;
    private final MovieAssembler movieAssembler;
    private final ActorFacade actorFacade;

    public MovieDto findById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(RuntimeException::new);
        return movieAssembler.fromDomain(movie);
    }

    public List<MovieDto> findAllByActorId(Long actorId) {
        return movieRepository.findAllByActorId(actorId).stream()
                .map(movieAssembler::fromDomain)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long addMovie(MovieDto movieDto) {
        Movie movie = movieAssembler.toDomain(movieDto);
        return movieRepository.save(movie).getId();
    }

    @Transactional
    public void updateMovie(Long movieId, MovieDto dto) {
        Movie movie = fetchMovieById(movieId);
        movie.setTitle(dto.getTitle());
    }

    @Transactional
    public void assignActorsToMovie(Long movieId, AssignMovieRequest dto) {
        Movie movie = fetchMovieById(movieId);
        movie.getActors().addAll(actorFacade.findActorsById(dto.getActors()));
    }

    public Movie fetchMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie with given id not found"));
    }

}
