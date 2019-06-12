package pl.solutions.software.sokolik.bartosz.movie.domain;

import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryDto;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.MovieDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
class MovieAssembler {

    MovieDto fromDomain(Movie movie) {
        List<CategoryDto> categories = movie.getCategories()
                .stream()
                .map(c -> new CategoryDto(c.getName()))
                .collect(Collectors.toList());

        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .categories(categories)
                .build();
    }

    Movie toDomain(MovieDto dto) {
        return Movie.builder()
                .title(dto.getTitle())
                .build();
    }

}
