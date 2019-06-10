package pl.solutions.software.sokolik.bartosz.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solutions.software.sokolik.bartosz.actor.dto.ActorDto;
import pl.solutions.software.sokolik.bartosz.actor.dto.ActorListDto;
import pl.solutions.software.sokolik.bartosz.movie.MovieFacade;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorFacade {

    private final ActorAssembler actorAssembler;
    private final ActorRepository actorRepository;
    private final MovieFacade movieFacade;

    @Transactional(readOnly = true)
    public ActorListDto findAllActorsWithMovies() {
        return null;
    }

    @Transactional
    public Long addActor(ActorDto dto) {
        Actor actor = actorAssembler.fromDto(dto);
        return actorRepository.save(actor).getId();
    }

    public List<Actor> findActorsById(List<Long> id) {
        return actorRepository.findAllById(id);
    }
}
