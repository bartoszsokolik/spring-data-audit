package pl.solutions.software.sokolik.bartosz.movie.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.solutions.software.sokolik.bartosz.infrastracture.AbstractListDto;

import java.util.List;

@Data
@AllArgsConstructor
public class MovieListDto extends AbstractListDto<MovieDto> {

    public MovieListDto(List<MovieDto> data) {
        super(data.size(), data);
    }
}
