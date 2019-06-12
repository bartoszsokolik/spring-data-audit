package pl.solutions.software.sokolik.bartosz.category.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryAlreadyExistsException;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryDto;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryListDto;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryFacade {

    private final CategoryRepository categoryRepository;
    private final CategoryAssembler categoryAssembler;

    public CategoryListDto findAll() {
        List<CategoryDto> categories = categoryRepository.findAll()
                .stream()
                .map(categoryAssembler::fromDomain)
                .collect(Collectors.toList());
        return new CategoryListDto(categories);
    }

    public Long addCategory(CategoryDto dto) {
        if (categoryRepository.existsByName(dto.getName())) {
            throw new CategoryAlreadyExistsException(String.format("Category with name %s already exists", dto.getName()));
        }

        return categoryRepository.save(new Category(dto.getName())).getId();
    }

    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name).orElseThrow(() -> new CategoryNotFoundException(String.format("Category with name %s not found", name)));
    }

}
