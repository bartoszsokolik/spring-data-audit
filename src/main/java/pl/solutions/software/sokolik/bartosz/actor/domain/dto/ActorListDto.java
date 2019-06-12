package pl.solutions.software.sokolik.bartosz.actor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import pl.solutions.software.sokolik.bartosz.infrastracture.AbstractListDto;

import java.util.List;

@Data
@AllArgsConstructor
public class ActorListDto extends AbstractListDto<ActorDto> {

    public ActorListDto(List<ActorDto> data) {
        super(data.size(), data);
    }
}
