package pl.solutions.software.sokolik.bartosz.category.domain;

import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryDto;

@Component
public class CategoryAssembler {

    public CategoryDto fromDomain(Category category) {
        return CategoryDto.builder()
                .name(category.getName())
                .build();
    }

    public Category fromDto(CategoryDto dto) {
        return Category.builder()
                .name(dto.getName())
                .build();
    }
}
