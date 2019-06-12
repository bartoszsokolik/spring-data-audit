package pl.solutions.software.sokolik.bartosz.actor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.solutions.software.sokolik.bartosz.infrastracture.AbstractDto;
import pl.solutions.software.sokolik.bartosz.movie.domain.dto.MovieDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto implements AbstractDto {

    private Long id;

    private String firstName;

    private String lastName;

    private List<MovieDto> movies;
}

