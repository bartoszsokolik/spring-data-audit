package pl.solutions.software.sokolik.bartosz.actor.domain;

import org.junit.Before;
import org.junit.Test;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorDto;
import pl.solutions.software.sokolik.bartosz.category.domain.Category;
import pl.solutions.software.sokolik.bartosz.movie.domain.Movie;

import java.util.Collections;
import java.util.Set;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ActorAssemblerTest {

    private static final String MOVIE_TITLE = "Star Wars";
    private static final String CATEGORY_NAME = "Science fiction";
    private static final String ACTOR_FIRST_NAME = "Mark";
    private static final String ACTOR_LAST_NAME = "Hamill";
    private static final Long ID = 1L;

    private ActorAssembler actorAssembler;


    @Before
    public void setUp() {
        actorAssembler = new ActorAssembler();
    }

    @Test
    public void fromDomain() {
        Set<Category> categories = Collections.singleton(new Category(CATEGORY_NAME));
        Set<Movie> movies = Collections.singleton(Movie.builder().id(ID)
                .title(MOVIE_TITLE)
                .categories(categories)
                .build());

        Actor actor = Actor.builder().id(ID)
                .firstName(ACTOR_FIRST_NAME)
                .lastName(ACTOR_LAST_NAME)
                .movies(movies)
                .build();

        ActorDto actual = actorAssembler.fromDomain(actor);

        assertEquals(ID, actual.getId());
        assertEquals(ACTOR_FIRST_NAME, actual.getFirstName());
        assertEquals(ACTOR_LAST_NAME, actual.getLastName());
        assertThat(actual.getMovies(), hasSize(1));
        assertEquals(MOVIE_TITLE, actual.getMovies().get(0).getTitle());
        assertThat(actual.getMovies().get(0).getCategories(), hasSize(1));
        assertEquals(CATEGORY_NAME, actual.getMovies().get(0).getCategories().get(0).getName());
    }

    @Test
    public void fromDto() {
        ActorDto dto = ActorDto.builder()
                .firstName(ACTOR_FIRST_NAME)
                .lastName(ACTOR_LAST_NAME)
                .build();

        Actor actual = actorAssembler.fromDto(dto);

        assertEquals(ACTOR_FIRST_NAME, actual.getFirstName());
        assertEquals(ACTOR_LAST_NAME, actual.getLastName());
    }
}