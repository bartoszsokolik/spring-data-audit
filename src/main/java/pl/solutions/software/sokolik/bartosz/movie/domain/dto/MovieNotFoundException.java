package pl.solutions.software.sokolik.bartosz.movie.domain.dto;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String message) {
        super(message);
    }
}
