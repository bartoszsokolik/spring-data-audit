package pl.solutions.software.sokolik.bartosz.movie.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryDto;
import pl.solutions.software.sokolik.bartosz.infrastracture.AbstractDto;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto implements AbstractDto {

    private Long id;

    private String title;

    private List<CategoryDto> categories;

    public MovieDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
