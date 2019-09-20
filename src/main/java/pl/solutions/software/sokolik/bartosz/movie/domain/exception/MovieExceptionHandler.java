package pl.solutions.software.sokolik.bartosz.movie.domain.exception;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.solutions.software.sokolik.bartosz.infrastracture.ErrorDto;

@ControllerAdvice
public class MovieExceptionHandler {

  @ResponseBody
  @ResponseStatus(NOT_FOUND)
  @ExceptionHandler(MovieNotFoundException.class)
  ErrorDto handleMovieNotFoundException(MovieNotFoundException e) {
    return new ErrorDto(NOT_FOUND.value(), e.getMessage());
  }
}
