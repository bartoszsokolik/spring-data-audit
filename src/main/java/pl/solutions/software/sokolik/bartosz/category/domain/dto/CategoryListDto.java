package pl.solutions.software.sokolik.bartosz.category.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.solutions.software.sokolik.bartosz.infrastracture.AbstractListDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class CategoryListDto extends AbstractListDto<CategoryDto> {

    public CategoryListDto(List<CategoryDto> data) {
        super(data.size(), data);
    }
}
