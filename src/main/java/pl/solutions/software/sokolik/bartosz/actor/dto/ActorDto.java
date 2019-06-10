package pl.solutions.software.sokolik.bartosz.actor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.solutions.software.sokolik.bartosz.movie.dto.MovieDto;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto {

    private Long id;

    private String firstName;

    private String lastName;

    private List<MovieDto> movies;
}

