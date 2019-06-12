package pl.solutions.software.sokolik.bartosz.movie.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddCategoryRequest {

    private Long movieId;

    private String categoryName;
}
