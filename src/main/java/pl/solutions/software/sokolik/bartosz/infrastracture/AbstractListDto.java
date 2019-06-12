package pl.solutions.software.sokolik.bartosz.infrastracture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractListDto<T extends AbstractDto> {

    private Integer totalCount;

    private List<T> data;
}
