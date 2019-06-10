package pl.solutions.software.sokolik.bartosz.movie;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.solutions.software.sokolik.bartosz.movie.dto.AssignMovieRequest;
import pl.solutions.software.sokolik.bartosz.movie.dto.MovieDto;

import java.net.URI;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
class MovieController {

    private final MovieFacade movieFacade;

    @GetMapping("/{id}")
    ResponseEntity<MovieDto> findOne(@PathVariable Long id) {
        return new ResponseEntity<>(movieFacade.findById(id), HttpStatus.OK);
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
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/actors")
    ResponseEntity<Void> assignActorsToMovie(@PathVariable Long id, @RequestBody AssignMovieRequest dto) {
        movieFacade.assignActorsToMovie(id, dto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
