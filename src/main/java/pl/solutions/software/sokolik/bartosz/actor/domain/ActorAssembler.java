package pl.solutions.software.sokolik.bartosz.actor.domain;

import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorDto;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryDto;
import pl.solutions.software.sokolik.bartosz.movie.domain.Movie;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
class ActorAssembler {

    ActorDto fromDomain(Actor actor) {
        List<MovieDto> movies = actor.getMovies()
                .stream()
                .map(m -> new MovieDto(m.getId(), m.getTitle(), mapCategories(m)))
                .collect(Collectors.toList());

        return ActorDto.builder()
                .id(actor.getId())
                .firstName(actor.getFirstName())
                .lastName(actor.getLastName())
                .movies(movies)
                .build();
    }

    Actor fromDto(ActorDto dto) {
        return Actor.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .build();
    }

    private List<CategoryDto> mapCategories(Movie movie) {
        return movie.getCategories()
                .stream().map(c -> new CategoryDto(c.getName()))
                .collect(Collectors.toList());
    }


}
