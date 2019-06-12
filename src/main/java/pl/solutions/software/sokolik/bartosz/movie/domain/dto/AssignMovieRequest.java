package pl.solutions.software.sokolik.bartosz.movie.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignMovieRequest {

    private List<Long> actors;
}
