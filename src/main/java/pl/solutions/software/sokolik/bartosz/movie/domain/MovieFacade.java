package pl.solutions.software.sokolik.bartosz.movie.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solutions.software.sokolik.bartosz.actor.domain.ActorFacade;
import pl.solutions.software.sokolik.bartosz.category.domain.Category;
import pl.solutions.software.sokolik.bartosz.category.domain.CategoryFacade;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.*;

import java.util.List;
import java.util.stream.Collectors;
import pl.solutions.software.sokolik.bartosz.movie.domain.exception.MovieNotFoundException;

@Service
@RequiredArgsConstructor
public class MovieFacade {

    private final MovieRepository movieRepository;
    private final MovieAssembler movieAssembler;
    private final CategoryFacade categoryFacade;
    private final ActorFacade actorFacade;

    @Transactional
    public MovieListDto findAll() {
        List<MovieDto> movies = movieRepository.findAll()
                .stream()
                .map(movieAssembler::fromDomain)
                .collect(Collectors.toList());
        return new MovieListDto(movies);
    }

    public MovieDto findByTitle(String title) {
        return movieRepository.findByTitle(title)
            .map(movieAssembler::fromDomain)
            .orElseThrow(() -> new MovieNotFoundException("Movie with given title not found"));
    }

    @Transactional
    public MovieDto findById(Long id) {
        return movieAssembler.fromDomain(fetchMovieById(id));
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

    @Transactional
    public void addCategoryToMovie(AddCategoryRequest dto) {
        Category category = categoryFacade.findCategoryByName(dto.getCategoryName());
        Movie movie = fetchMovieById(dto.getMovieId());
        movie.getCategories().add(category);
    }

    private Movie fetchMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException("Movie with given id not found"));
    }

}
