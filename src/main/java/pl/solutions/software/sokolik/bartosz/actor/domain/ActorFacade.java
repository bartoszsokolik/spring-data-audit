package pl.solutions.software.sokolik.bartosz.actor.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorDto;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorListDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActorFacade {

    private final ActorAssembler actorAssembler;
    private final ActorRepository actorRepository;

    @Transactional(readOnly = true)
    public ActorListDto findAllActorsWithMovies() {
        List<Actor> actorsWithMovies = actorRepository.findActorsWithMovies();

        List<ActorDto> actors = actorsWithMovies
                .stream()
                .map(actorAssembler::fromDomain)
                .collect(Collectors.toList());
        return new ActorListDto(actors);
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
