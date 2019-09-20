package pl.solutions.software.sokolik.bartosz.configuration;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.solutions.software.sokolik.bartosz.movie.domain.Movie;
import pl.solutions.software.sokolik.bartosz.movie.domain.MovieRepository;

@Component
@Profile("it")
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

  private final MovieRepository movieRepository;

  @Override
  public void run(String... args) throws Exception {
    movieRepository.saveAll(List.of(new Movie("Star Wars"), new Movie("Harry Potter")));
  }
}
