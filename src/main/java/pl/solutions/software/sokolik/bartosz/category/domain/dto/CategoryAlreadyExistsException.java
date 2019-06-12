package pl.solutions.software.sokolik.bartosz.category.domain.dto;

public class CategoryAlreadyExistsException extends RuntimeException {

    public CategoryAlreadyExistsException(String message) {
        super(message);
    }
}
