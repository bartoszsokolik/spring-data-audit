package pl.solutions.software.sokolik.bartosz.category.domain.dto;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
