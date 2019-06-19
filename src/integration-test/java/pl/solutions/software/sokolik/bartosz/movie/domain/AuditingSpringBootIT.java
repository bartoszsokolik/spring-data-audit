package pl.solutions.software.sokolik.bartosz.movie.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.AuditorAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static pl.solutions.software.sokolik.bartosz.configuration.AuditingConstants.DEFAULT_AUDITOR;

@RunWith(SpringRunner.class)
@ActiveProfiles("it")
@SpringBootTest
public class AuditingSpringBootIT {

    @Autowired
    private AuditorAware<String> auditorAware;

    @Autowired
    private MovieRepository movieRepository;

    @Test
    public void testCurrentAuditor() {
        String currentAuditor = auditorAware.getCurrentAuditor().get();
        assertEquals(DEFAULT_AUDITOR, currentAuditor);
    }

    @Test
    public void movieRepositoryTest() {
        Movie movie = new Movie("Movie");
        movieRepository.save(movie);

        List<Movie> movies = movieRepository.findAll();
        Movie result = movies.get(0);
        assertEquals(DEFAULT_AUDITOR, result.getCreatedBy().get());
    }

}
