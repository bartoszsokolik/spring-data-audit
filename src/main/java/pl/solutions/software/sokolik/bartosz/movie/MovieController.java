package pl.solutions.software.sokolik.bartosz.movie;

import static org.springframework.http.HttpStatus.OK;

import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.solutions.software.sokolik.bartosz.movie.domain.MovieFacade;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.AddCategoryRequest;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.AssignMovieRequest;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.MovieDto;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.MovieListDto;
import pl.solutions.software.sokolik.bartosz.paging.CustomPageRequest;
import pl.solutions.software.sokolik.bartosz.paging.PagedResponse;
import pl.solutions.software.sokolik.bartosz.paging.SortDirection;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
class MovieController {

    private final MovieFacade movieFacade;

    @GetMapping("/{id}")
    ResponseEntity<MovieDto> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(movieFacade.findById(id), OK);
    }

    @GetMapping("/title/{title}")
    ResponseEntity<MovieDto> findByTitle(@PathVariable String title) {
        return new ResponseEntity<>(movieFacade.findByTitle(title), OK);
    }

    @GetMapping
    ResponseEntity<MovieListDto> findAll() {
        return new ResponseEntity<>(movieFacade.findAll(), OK);
    }

    @GetMapping("/paged")
    ResponseEntity<PagedResponse<MovieDto>> paged(CustomPageRequest pageRequest) {
        return new ResponseEntity<>(movieFacade.getMoviesPaged(pageRequest), OK);
    }

    @GetMapping("/all/paged")
    ResponseEntity<PagedResponse<MovieDto>> getAllPages(@RequestParam(required = false, defaultValue = "1") int page,
                                                        @RequestParam(required = false, defaultValue = "10") int size,
                                                        @RequestParam(name = "sort_by", required = false, defaultValue = "id") String sortBy,
                                                        @RequestParam(name = "sort_how", required = false, defaultValue = "desc") SortDirection sortDirection) {
        return new ResponseEntity<>(movieFacade.getMoviesPaged(new CustomPageRequest(page, size, sortDirection, sortBy)), OK);
    }

    @PostMapping
    ResponseEntity<Void> addMovie(@RequestBody MovieDto dto) {

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(movieFacade.addMovie(dto))
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> updateMovie(@PathVariable Long id, @RequestBody MovieDto dto) {
        movieFacade.updateMovie(id, dto);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/{id}/actors")
    ResponseEntity<Void> assignActorsToMovie(@PathVariable Long id, @RequestBody AssignMovieRequest dto) {
        movieFacade.assignActorsToMovie(id, dto);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/category")
    ResponseEntity<Void> addCategoryToMovie(@RequestBody AddCategoryRequest dto) {
        movieFacade.addCategoryToMovie(dto);
        return new ResponseEntity<>(OK);
    }

}
