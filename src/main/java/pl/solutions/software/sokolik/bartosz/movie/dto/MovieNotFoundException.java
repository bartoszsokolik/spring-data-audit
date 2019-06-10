package pl.solutions.software.sokolik.bartosz.movie.dto;

public class MovieNotFoundException extends RuntimeException {

    public MovieNotFoundException(String message) {
        super(message);
    }
}
