package pl.solutions.software.sokolik.bartosz.actor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorListDto {

    private List<ActorDto> actors;
}
