package pl.solutions.software.sokolik.bartosz.movie;

import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.movie.dto.MovieDto;

@Component
class MovieAssembler {

    MovieDto fromDomain(Movie movie) {
        return MovieDto.builder()
                .title(movie.getTitle())
                .build();
    }

    Movie toDomain(MovieDto dto) {
        return Movie.builder()
                .title(dto.getTitle())
                .build();
    }

}
