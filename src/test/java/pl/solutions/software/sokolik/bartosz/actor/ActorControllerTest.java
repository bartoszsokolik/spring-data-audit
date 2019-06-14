package pl.solutions.software.sokolik.bartosz.actor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.solutions.software.sokolik.bartosz.actor.domain.ActorFacade;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorDto;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorListDto;

import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ActorControllerTest {

    @Mock
    private ActorFacade actorFacade;

    @InjectMocks
    private ActorController actorController;

    @Before
    public void setUp() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setScheme("http");
        request.setServerName("localhost");
        request.setServerPort(8080);
        request.setRequestURI("/api/actors");
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void testFindAllActorsWithMovies() {
        ActorListDto dto = new ActorListDto();

        when(actorFacade.findAllActorsWithMovies()).thenReturn(dto);

        ResponseEntity<ActorListDto> expected = new ResponseEntity<>(dto, HttpStatus.OK);
        ResponseEntity<ActorListDto> actual = actorController.findAllActors();

        assertEquals(expected, actual);
        verify(actorFacade).findAllActorsWithMovies();
    }

    @Test
    public void testAddActor() {
        final Long id = 1L;
        ActorDto dto = new ActorDto();
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        when(actorFacade.addActor(dto)).thenReturn(id);


        ResponseEntity<Void> expected = ResponseEntity.created(location).build();
        ResponseEntity<Void> actual = actorController.addActor(dto);

        assertEquals(expected, actual);
    }
}
