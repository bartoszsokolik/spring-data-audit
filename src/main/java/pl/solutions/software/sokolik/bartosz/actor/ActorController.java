package pl.solutions.software.sokolik.bartosz.actor;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.solutions.software.sokolik.bartosz.actor.domain.ActorFacade;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorDto;
import pl.solutions.software.sokolik.bartosz.actor.domain.dto.ActorListDto;

import java.net.URI;

@RestController
@RequestMapping("/api/actors")
@RequiredArgsConstructor
class ActorController {

    private final ActorFacade actorFacade;

    @GetMapping
    ResponseEntity<ActorListDto> findAllActors() {
        return new ResponseEntity<>(actorFacade.findAllActorsWithMovies(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Void> addActor(@RequestBody ActorDto dto) {

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(actorFacade.addActor(dto))
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
