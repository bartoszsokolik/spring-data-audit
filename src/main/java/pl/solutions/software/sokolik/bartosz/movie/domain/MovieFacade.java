package pl.solutions.software.sokolik.bartosz.movie.domain;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solutions.software.sokolik.bartosz.actor.domain.ActorFacade;
import pl.solutions.software.sokolik.bartosz.category.domain.Category;
import pl.solutions.software.sokolik.bartosz.category.domain.CategoryFacade;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.AddCategoryRequest;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.AssignMovieRequest;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.MovieDto;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.MovieListDto;
import pl.solutions.software.sokolik.bartosz.movie.domain.exception.MovieNotFoundException;
import pl.solutions.software.sokolik.bartosz.paging.CustomPageRequest;
import pl.solutions.software.sokolik.bartosz.paging.PagedResponse;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieFacade {

  private final MovieRepository movieRepository;
  private final MovieAssembler movieAssembler;
  private final CategoryFacade categoryFacade;
  private final ActorFacade actorFacade;

  public MovieListDto findAll() {
    List<MovieDto> movies = movieRepository.findAll()
        .stream()
        .map(movieAssembler::fromDomain)
        .collect(Collectors.toList());
    return new MovieListDto(movies);
  }

  public PagedResponse<MovieDto> getMoviesPaged(CustomPageRequest customPageRequest) {
    PageRequest pageRequest = PageRequest.of(customPageRequest.getPage(),
        customPageRequest.getSize(), customPageRequest.getOrder(), customPageRequest.getSortBy());

    Page<MovieDto> page = movieRepository.findAll(pageRequest).map(movieAssembler::fromDomain);
    return new PagedResponse<>(page);
  }

  public MovieDto findByTitle(String title) {
    return movieRepository.findByTitle(title)
        .map(movieAssembler::fromDomain)
        .orElseThrow(() -> new MovieNotFoundException("Movie with given title not found"));
  }

  public MovieDto findById(Long id) {
    return movieAssembler.fromDomain(fetchMovieById(id));
  }

  public Long addMovie(MovieDto movieDto) {
    Movie movie = movieAssembler.toDomain(movieDto);
    return movieRepository.save(movie).getId();
  }

  public void updateMovie(Long movieId, MovieDto dto) {
    Movie movie = fetchMovieById(movieId);
    movie.setTitle(dto.getTitle());
  }

  public void assignActorsToMovie(Long movieId, AssignMovieRequest dto) {
    Movie movie = fetchMovieById(movieId);
    movie.getActors().addAll(actorFacade.findActorsById(dto.getActors()));
  }

  public void addCategoryToMovie(AddCategoryRequest dto) {
    Category category = categoryFacade.findCategoryByName(dto.getCategoryName());
    Movie movie = fetchMovieById(dto.getMovieId());
    movie.getCategories().add(category);
  }

  private Movie fetchMovieById(Long id) {
    return movieRepository.findById(id)
        .orElseThrow(() -> new MovieNotFoundException("Movie with given id not found"));
  }

}
