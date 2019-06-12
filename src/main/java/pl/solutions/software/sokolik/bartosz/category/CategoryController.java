package pl.solutions.software.sokolik.bartosz.category;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.solutions.software.sokolik.bartosz.category.domain.CategoryFacade;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryDto;
import pl.solutions.software.sokolik.bartosz.category.domain.dto.CategoryListDto;

import java.net.URI;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
class CategoryController {

    private final CategoryFacade categoryFacade;

    @GetMapping
    ResponseEntity<CategoryListDto> findAllCategories() {
        return new ResponseEntity<>(categoryFacade.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> addCategory(@RequestBody CategoryDto dto) {
        Long id = categoryFacade.addCategory(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
