package pl.solutions.software.sokolik.bartosz.category.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.solutions.software.sokolik.bartosz.infrastracture.AbstractDto;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CategoryDto implements AbstractDto {

    private String name;
}
