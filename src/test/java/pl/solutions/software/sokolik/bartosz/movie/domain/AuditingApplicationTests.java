package pl.solutions.software.sokolik.bartosz.movie.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import pl.solutions.software.sokolik.bartosz.config.TestAuditingConfiguration;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static pl.solutions.software.sokolik.bartosz.configuration.AuditingConstants.TEST_AUDITOR;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@Import(TestAuditingConfiguration.class)
public class AuditingApplicationTests {

    @Autowired
    private AuditorAware<String> auditorAware;

    @Autowired
    private MovieRepository movieRepository;

	@Test
	public void testCurrentAuditor() {
        String currentAuditor = auditorAware.getCurrentAuditor().get();
        assertEquals(TEST_AUDITOR, currentAuditor);
	}

    @Test
    public void movieRepositoryTest() {
        Movie movie = new Movie("Movie");
        movieRepository.save(movie);

        List<Movie> movies = movieRepository.findAll();
        Movie result = movies.get(0);
        assertEquals(TEST_AUDITOR, result.getCreatedBy().get());
    }

}
